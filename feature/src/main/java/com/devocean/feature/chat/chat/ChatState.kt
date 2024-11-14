package com.devocean.feature.chat.chat

import com.devocean.feature.chat.chat.model.ChatListModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class ChatState(
    val chatList: PersistentList<ChatListModel> = persistentListOf()
)