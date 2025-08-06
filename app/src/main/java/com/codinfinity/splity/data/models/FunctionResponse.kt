package com.codinfinity.splity.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FunctionResponse(
    @SerialName("message") val message: String,
)