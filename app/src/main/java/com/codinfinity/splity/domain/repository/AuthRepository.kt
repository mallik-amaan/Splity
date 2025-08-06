package com.codinfinity.splity.domain.repository

import io.github.jan.supabase.auth.user.UserInfo
import java.io.InputStream

interface AuthRepository {
    //for remote auth
    suspend fun signIn(email: String, password: String): UserInfo?
    suspend fun signUp(email: String, password: String): UserInfo?
    suspend fun logout(): Boolean
    suspend fun signInWithGoogle(): Boolean
    suspend fun setUpBasicInfo(name:String, profilePicture: InputStream, country:String): Boolean

    //for local auth caching
    suspend fun saveUserInfo(userInfo: UserInfo)
    suspend fun getUserInfo(): UserInfo?
    suspend fun clearUserInfo()
}