package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeLatestChatResponseDto(
    @SerialName("session_id")
    val sessionId: Int,
    @SerialName("user_id")
    val userId: Int?,
    @SerialName("summary")
    val summary: String,
    @SerialName("type")
    val type: String?,
    @SerialName("chats")
    val chats: List<Chat>,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("updated_at")
    val updatedAt: String?
)

@Serializable
data class Chat(
    @SerialName("session_id")
    val sessionId: Int,
    @SerialName("idx")
    val idx: Int,
    @SerialName("type")
    val type: String,
    @SerialName("end")
    val end: Boolean?,
    @SerialName("content")
    val content: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)
