package com.devocean.domain.repository

import com.devocean.domain.entity.chat.ChatList
import com.devocean.domain.entity.selectedchat.SelectedChat
import com.devocean.domain.entity.selectedchat.SummaryReport

interface ChatRepository {
    suspend fun getChatList(): Result<List<ChatList>>

    suspend fun getSelectedChat(sessionId: Int): Result<List<SelectedChat>>

    suspend fun getSummaryReport(sessionId: Int): Result<List<SummaryReport>>
}