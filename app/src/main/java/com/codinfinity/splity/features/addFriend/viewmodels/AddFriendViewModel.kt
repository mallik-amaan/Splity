package com.codinfinity.splity.features.addFriend.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinfinity.splity.data.models.UserModel
import com.codinfinity.splity.domain.repository.AddFriendRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddFriendViewModel @Inject constructor(
    private val addFriendRepository: AddFriendRepository
): ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> = _isLoading

    private val _result = MutableStateFlow<UserModel?>(null)
    val result: Flow<UserModel?> = _result


    private val _email = MutableStateFlow("")
    val email: Flow<String> = _email

    fun onEmailChange(newEmail: String){
        _email.value = newEmail
    }

    fun searchUser(email: String){
        _isLoading.value = true
        viewModelScope.launch {
            val user = addFriendRepository.searchFriendByEmail(
                email = email
            )
            _result.value = user
        }
        _isLoading.value = false
    }
}