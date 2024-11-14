package com.devocean.data.repositoryimpl

import com.devocean.data.datasource.ChatDataSource
import com.devocean.data.mapper.chat.toChatList
import com.devocean.data.mapper.chat.toChat
import com.devocean.data.mapper.chat.toContext
import com.devocean.domain.entity.chat.ChatList
import com.devocean.domain.entity.selectedchat.SelectedChat
import com.devocean.domain.entity.selectedchat.SummaryReport
import com.devocean.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val dataSource: ChatDataSource
) : ChatRepository {

    override suspend fun getChatList(): Result<List<ChatList>> =
        runCatching {
            dataSource.getChatList().toChatList()
        }

    override suspend fun getSelectedChat(sessionId: Int): Result<List<SelectedChat>> =
        runCatching {
            dataSource.getSelectedChat(sessionId).toChat()
        }

    override suspend fun getSummaryReport(sessionId: Int): Result<List<SummaryReport>> =
        runCatching {
            dataSource.getSummaryReport(sessionId).toContext()
        }
}