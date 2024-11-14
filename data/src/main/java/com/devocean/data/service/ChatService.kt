package com.devocean.data.service

import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.data.dto.response.SelectedChatResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatService {
    @GET("/api/chat/list")
    suspend fun getChatList(): List<ChatResponseDto>

    @GET("/api/chat/{session_id}")
    suspend fun getSelectedChat(
        @Path("session_id") sessionId: Int,
    ): SelectedChatResponseDto
}