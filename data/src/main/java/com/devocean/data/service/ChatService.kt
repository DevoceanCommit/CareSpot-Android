package com.devocean.data.service

import com.devocean.data.dto.response.ChatResponseDto
import retrofit2.http.GET

interface ChatService {

    @GET("/api/chat/list")
    suspend fun getChatList(): ChatResponseDto

}