package com.codinfinity.splity.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserModel(

    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("created_at") val createdAt: String? = null,
    )
