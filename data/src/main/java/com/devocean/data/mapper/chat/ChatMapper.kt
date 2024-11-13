package com.devocean.data.mapper.chat

import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.domain.entity.chat.ChatList

fun ChatResponseDto.toChatList() =
    ChatList(
        sessionId = sessionId,
        createdAt = createdAt,
        summary = summary
    )