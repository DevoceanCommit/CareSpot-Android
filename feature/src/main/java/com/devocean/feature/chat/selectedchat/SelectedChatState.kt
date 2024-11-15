package com.devocean.feature.chat.selectedchat

import com.devocean.feature.chat.selectedchat.model.SelectedChatModel
import com.devocean.feature.chat.selectedchat.model.SummaryReportModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class SelectedChatState(
    val chat: PersistentList<SelectedChatModel> = persistentListOf(),
    val summary: PersistentList<SummaryReportModel> = persistentListOf()
)