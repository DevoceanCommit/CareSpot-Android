package com.devocean.data.service

import com.devocean.data.dto.response.HomeLatestChatResponseDto
import com.devocean.data.dto.response.SensorResponseDto
import retrofit2.http.GET

interface HomeService {
    @GET("/api/chat/latest")
    suspend fun getLatestChat(): HomeLatestChatResponseDto

    @GET("/api/sensor")
    suspend fun getSensor(): List<SensorResponseDto>
}