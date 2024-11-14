package com.devocean.data.mapper.chat

import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.domain.entity.chat.ChatList

fun List<ChatResponseDto>.toChatList(): List<ChatList> =
    this.map { chatResponseDto ->
        ChatList(
            summary = chatResponseDto.summary,
            updated_at = chatResponseDto.updated_at,
            id = chatResponseDto.id
        )
    }