package com.codinfinity.splity.core.services.api

import com.codinfinity.splity.data.models.FunctionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SupabaseAPI {

    @POST("smart-responder")
    suspend fun callSmartResponder(@Body params: Map<String, Any>): Response<FunctionResponse>
}