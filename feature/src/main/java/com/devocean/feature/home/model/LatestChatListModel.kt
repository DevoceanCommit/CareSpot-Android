package com.devocean.feature.home.model

import com.devocean.domain.entity.home.LatestChat

data class LatestChatListModel(
    val type: String,
    val content: String
)

fun LatestChat.toModel() = LatestChatListModel(
    type = type,
    content = content
)