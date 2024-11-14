package com.devocean.data.mapper.home

import com.devocean.data.dto.response.HomeLatestChatResponseDto
import com.devocean.domain.entity.home.LatestChat

fun HomeLatestChatResponseDto.toLatestChat(): List<LatestChat> =
    this.chats.map { chat ->
        LatestChat(
            type = chat.type,
            content = chat.content
        )
    }
