package com.devocean.data.repositoryimpl

import com.devocean.data.datasource.HomeDataSource
import com.devocean.data.mapper.home.toLatestChat
import com.devocean.domain.entity.home.LatestChat
import com.devocean.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val dataSource: HomeDataSource
) : HomeRepository {
    override suspend fun getLatestChat(): Result<List<LatestChat>> =
        runCatching {
            dataSource.getHomeLatestChat().toLatestChat()
        }
}