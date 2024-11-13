package com.devocean.data.datasourceimpl

import com.devocean.data.datasource.ChatDataSource
import com.devocean.data.dto.response.ChatResponseDto
import com.devocean.data.service.ChatService
import javax.inject.Inject

class ChatDataSourceImpl @Inject constructor(
    private val service: ChatService
) : ChatDataSource {

    override suspend fun getChatList(): ChatResponseDto = service.getChatList()

}