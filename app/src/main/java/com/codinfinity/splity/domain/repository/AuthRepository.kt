package com.codinfinity.splity.domain.repository

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Boolean
    suspend fun logout(): Boolean
    suspend fun signInWithGoogle(): Boolean
}