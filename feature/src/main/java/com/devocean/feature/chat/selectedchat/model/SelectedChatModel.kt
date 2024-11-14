package com.devocean.feature.chat.selectedchat.model

import com.devocean.domain.entity.chat.SelectedChat

data class SelectedChatModel(
    val type: String,
    val content: String
)

fun SelectedChat.toSelectedChatModel() = SelectedChatModel(
    type = type,
    content = content
)
