package com.devocean.data.repositoryimpl

import com.devocean.data.datasource.ChatDataSource
import com.devocean.data.mapper.chat.toChatList
import com.devocean.domain.entity.chat.ChatList
import com.devocean.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val dataSource: ChatDataSource
) : ChatRepository {

    override suspend fun getChatList(): Result<ChatList> =
        runCatching {
            dataSource.getChatList().toChatList()
        }

}