package com.devocean.domain.repository

import com.devocean.domain.entity.chat.ChatList

interface ChatRepository {

    suspend fun getChatList() : Result<List<ChatList>>

}