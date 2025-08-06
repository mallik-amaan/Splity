package com.codinfinity.splity.features.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinfinity.splity.di.UserSession
import com.codinfinity.splity.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository:AuthRepository,
    private val userSession: UserSession

):ViewModel(){
    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> = _isLoading

    private val _result = MutableStateFlow<Boolean?>(null)
    val result: Flow<Boolean?> = _result


    private val _email = MutableStateFlow("")
    val email: Flow<String> = _email

    private val _password = MutableStateFlow("")
    val password: Flow<String> = _password

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun OnSignIn(onComplete: () -> Unit) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val result = authRepository.signIn(
                    email = _email.value,
                    password = _password.value
                )
                userSession.setUser(result!!)
                _result.value=true
            } catch (e: Exception) {
                _result.value = false // or handle error
            } finally {
                _isLoading.value = false
                if(_result.value == true) {
                    onComplete()
                }
                else {
                    // Handle error case
                }
            }
        }
    }

}