package com.devocean.data.mapper.chat

import com.devocean.data.dto.response.SelectedChatResponseDto
import com.devocean.domain.entity.chat.SelectedChat

fun SelectedChatResponseDto.toChat(): List<SelectedChat> =
    this.chats.map { chat ->
        SelectedChat(
            type = chat.type,
            content = chat.content
        )
    }