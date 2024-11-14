package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SummaryReportResponseDto(
    @SerialName("session_id")
    val sessionId: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("title")
    val title: String,
    @SerialName("contents")
    val contents: List<Content>
)

@Serializable
data class Content(
    @SerialName("idx")
    val idx: Int,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("context")
    val context: String,
    @SerialName("created_at")
    val createdAt: String
)
