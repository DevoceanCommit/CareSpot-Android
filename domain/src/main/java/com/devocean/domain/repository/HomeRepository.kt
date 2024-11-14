package com.devocean.domain.repository

import com.devocean.domain.entity.home.LatestChat

interface HomeRepository {
    suspend fun getLatestChat(): Result<List<LatestChat>>
}