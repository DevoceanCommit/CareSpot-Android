package com.devocean.domain.repository

import com.devocean.domain.entity.home.LatestChat
import com.devocean.domain.entity.home.SensorData

interface HomeRepository {
    suspend fun getLatestChat(): Result<List<LatestChat>>

    suspend fun getSensor() : Result<SensorData>
}