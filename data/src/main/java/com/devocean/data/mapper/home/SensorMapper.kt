package com.devocean.data.mapper.home

import com.devocean.data.dto.response.SensorResponseDto
import com.devocean.domain.entity.home.SensorData

fun List<SensorResponseDto>.toSensorData(): SensorData =
    this.first().data.let { data ->
        SensorData(
            temperatureIn = data.temperature.indoor,
            movement = data.movement,
            soundIn = data.soundIn,
            humidityIn = data.humidity.indoor
        )
    }

