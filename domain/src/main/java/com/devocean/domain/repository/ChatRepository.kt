package com.devocean.domain.repository

import com.devocean.domain.entity.chat.ChatList
import com.devocean.domain.entity.selectedchat.SelectedChat

interface ChatRepository {
    suspend fun getChatList(): Result<List<ChatList>>

    suspend fun getSelectedChat(sessionId: Int): Result<List<SelectedChat>>
}