package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatResponseDto(
    @SerialName("created_at")
    val created_at: String,
    @SerialName("user_id")
    val user_id: Int?,
    @SerialName("summary")
    val summary: String,
    @SerialName("updated_at")
    val updated_at: String,
    @SerialName("type")
    val type: String?,
    @SerialName("id")
    val id: Int,
)