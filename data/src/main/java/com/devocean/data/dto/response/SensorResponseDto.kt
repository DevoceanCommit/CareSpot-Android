package com.devocean.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SensorResponseDto(
    @SerialName("timestamp")
    val timestamp: String,
    @SerialName("data")
    val data: SensorData
)

@Serializable
data class SensorData(
    @SerialName("movement")
    val movement: String,
    @SerialName("humidty")
    val humidity: Humidity,
    @SerialName("temperature")
    val temperature: Temperature,
    @SerialName("sound")
    val sound: String,
    @SerialName("sound_in")
    val soundIn: Int,
    @SerialName("gas")
    val gas: String
)

@Serializable
data class Humidity(
    @SerialName("in")
    val indoor: Int,
    @SerialName("out")
    val outdoor: Int
)

@Serializable
data class Temperature(
    @SerialName("in")
    val indoor: Int,
    @SerialName("out")
    val outdoor: Int
)
