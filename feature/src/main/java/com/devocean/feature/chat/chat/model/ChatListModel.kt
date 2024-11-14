package com.devocean.feature.chat.chat.model

import com.devocean.domain.entity.chat.ChatList

data class ChatListModel(
    val summary: String,
    val date: String,
    val id: Int,
)

fun ChatList.toModel() = ChatListModel(
    summary = summary,
    date = date,
    id = id
)