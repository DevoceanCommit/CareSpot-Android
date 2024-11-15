package com.devocean.feature.home

import com.devocean.feature.home.model.LatestChatListModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class HomeState(
    val latestChat: PersistentList<LatestChatListModel> = persistentListOf(),
    val temperature: Int = -1,
    val movement: String = "",
    val sound: Int = -1,
    val humidity: Int = -1
)
