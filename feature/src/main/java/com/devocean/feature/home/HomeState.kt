package com.devocean.feature.home

import com.devocean.feature.home.model.LatestChatListModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class HomeState(
    val latestChat: PersistentList<LatestChatListModel> = persistentListOf()
)
