package com.devocean.data.datasource

import com.devocean.data.dto.response.HomeLatestChatResponseDto
import com.devocean.data.dto.response.SensorResponseDto

interface HomeDataSource {
    suspend fun getHomeLatestChat(): HomeLatestChatResponseDto

    suspend fun getSensor(): List<SensorResponseDto>
}