package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChatResponseDto(
    @SerialName("session_id")
    val sessionId: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("summary")
    val summary: String
)