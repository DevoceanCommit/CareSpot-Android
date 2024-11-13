package com.devocean.data.datasource

import com.devocean.data.dto.response.ChatResponseDto

interface ChatDataSource {

    suspend fun getChatList(): ChatResponseDto

}