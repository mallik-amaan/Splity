package com.codinfinity.splity.features.auth.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinfinity.splity.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _navigationTarget = MutableStateFlow<Destination?>(null)
    val navigationTarget: Flow<Destination?> = _navigationTarget

    enum class Destination {
        HOME,
        LOGIN
    }

    init {
        checkUserSession()
    }

    private fun checkUserSession() {
        viewModelScope.launch {
            val user = authRepository.getUserInfo()
            if (user != null) {
                _navigationTarget.value = Destination.HOME
            } else {
                _navigationTarget.value = Destination.LOGIN
            }
        }
    }
}
