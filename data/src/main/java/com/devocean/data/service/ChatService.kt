package com.devocean.data.service

import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.data.dto.response.SelectedChatResponseDto
import com.devocean.data.dto.response.SummaryReportResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatService {
    @GET("/api/chat/list")
    suspend fun getChatList(): List<ChatResponseDto>

    @GET("/api/chat/{session_id}")
    suspend fun getSelectedChat(
        @Path("session_id") sessionId: Int,
    ): SelectedChatResponseDto

    @GET("/api/chat/{session_id}/summary")
    suspend fun getSummaryReport(
        @Path("session_id") sessionId: Int,
    ): SummaryReportResponseDto
}