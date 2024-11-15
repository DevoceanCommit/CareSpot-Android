package com.devocean.data.datasource

import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.data.dto.response.SelectedChatResponseDto
import com.devocean.data.dto.response.SummaryReportResponseDto

interface ChatDataSource {
    suspend fun getChatList(): List<ChatResponseDto>

    suspend fun getSelectedChat(sessionId: Int): SelectedChatResponseDto

    suspend fun getSummaryReport(sessionId: Int): SummaryReportResponseDto
}