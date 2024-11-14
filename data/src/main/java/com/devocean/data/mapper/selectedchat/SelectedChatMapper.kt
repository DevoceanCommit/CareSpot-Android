package com.devocean.data.mapper.selectedchat

import com.devocean.data.dto.response.SelectedChatResponseDto
import com.devocean.domain.entity.selectedchat.SelectedChat

fun SelectedChatResponseDto.toChat(): List<SelectedChat> =
    this.chats.map { chat ->
        SelectedChat(
            type = chat.type,
            content = chat.content
        )
    }