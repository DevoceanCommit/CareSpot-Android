package com.devocean.data.datasource

import com.devocean.data.dto.response.HomeLatestChatResponseDto

interface HomeDataSource {

    suspend fun getHomeLatestChat() : HomeLatestChatResponseDto

}