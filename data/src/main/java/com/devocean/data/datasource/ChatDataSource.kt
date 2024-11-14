package com.devocean.data.datasource

import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.data.dto.response.SelectedChatResponseDto

interface ChatDataSource {
    suspend fun getChatList(): List<ChatResponseDto>

    suspend fun getSelectedChat(sessionId: Int): SelectedChatResponseDto
}