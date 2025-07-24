package com.codinfinity.splity.core.services.api

import retrofit2.http.GET

interface SupabaseAPI {
    @GET("users")
    suspend fun getUsers(): List<String>

    
}