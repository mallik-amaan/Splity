package com.codinfinity.splity.features.auth.signUp

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinfinity.splity.di.UserSession
import com.codinfinity.splity.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.auth.user.UserInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.InputStream
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository:AuthRepository,
    private val userSession: UserSession

):ViewModel(){
    private val _isLoading = MutableStateFlow(false)
    val isLoading: Flow<Boolean> = _isLoading

    private val _result = MutableStateFlow<Boolean?>(null)
    val result: Flow<Boolean?> = _result


    // variable to hold the userInfo
    private val _user = MutableStateFlow<UserInfo?>(null)
    val user: Flow<UserInfo?> = _user

    //vars to handle input
    private val _email = MutableStateFlow("")
    val email: Flow<String> = _email

    private val _password = MutableStateFlow("")
    val password: Flow<String> = _password

    private val _name = MutableStateFlow("")
    val name: Flow<String> = _name

    private val _country = MutableStateFlow("")
    val country: Flow<String> = _country

    private val _imageURI = MutableStateFlow(Uri.EMPTY)
    val imageURI: Flow<Uri> = _imageURI


    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onCountryChange(newCountry: String) {
        _country.value = newCountry
    }

    fun onImageURIChange(newImageURI: Uri) {
        _imageURI.value = newImageURI
    }

    //viewModel functions

    fun onSignIn(onComplete: () -> Unit) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val result = authRepository.signUp(
                    email = _email.value,
                    password = _password.value
                )
                if(result==null){
                    _result.value = false
                }
                else{
                    _result.value = true
                    _user.value = result

                    authRepository.saveUserInfo(result)
                    userSession.setUser(result)
                }
            } catch (_: Exception) {
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

    fun addBasicInfo(
        onConvertToInputStream: (Uri) -> InputStream?,
        onComplete: () -> Unit) {
        _isLoading.value = true
        if(_imageURI.value == Uri.EMPTY) return
        else {
            val imageInput = onConvertToInputStream(_imageURI.value)
            viewModelScope.launch {
                try {
                    val result = authRepository.setUpBasicInfo(
                        name = _name.value,
                        country = _country.value,
                        profilePicture = imageInput!!,
                    )
                    _result.value = result

                    if(_result.value==true) onComplete()
                } catch (e: Exception) {
                    Log.d("AddBasicInfo", "addBasicInfo: ${e}")
                    _result.value = false // or handle error
                } finally {
                    _isLoading.value = false
                }
            }
        }
    }
}