package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatResponseDto(
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("user_id")
    val userId: Int?,
    @SerialName("summary")
    val summary: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("type")
    val type: String?,
    @SerialName("id")
    val id: Int,
)