package com.devocean.data.datasourceimpl

import com.devocean.data.datasource.HomeDataSource
import com.devocean.data.dto.response.HomeLatestChatResponseDto
import com.devocean.data.service.HomeService
import javax.inject.Inject

class HomeDataSourceImpl @Inject constructor(
    private val service: HomeService
) : HomeDataSource {

    override suspend fun getHomeLatestChat(): HomeLatestChatResponseDto = service.getLatestChat()

}