package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SummaryReportResponseDto(
    @SerialName("title")
    val title: String,
    @SerialName("contents")
    val contents: List<Content>,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("session_id")
    val sessionId: Int
)

@Serializable
data class Content(
    @SerialName("idx")
    val idx: Int,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("context")
    val context: String
)
