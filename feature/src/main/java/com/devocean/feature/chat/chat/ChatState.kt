package com.devocean.feature.chat.chat

import com.devocean.feature.chat.chat.model.ChatListModel

data class ChatState(
    val chatList: List<ChatListModel> = emptyList()
)