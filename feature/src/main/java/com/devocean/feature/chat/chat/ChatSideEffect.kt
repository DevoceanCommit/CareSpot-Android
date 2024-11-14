package com.devocean.feature.chat.chat

import androidx.annotation.StringRes

sealed class ChatSideEffect {
    data class NavigateToChatList(val id: Int) : ChatSideEffect()
    data class ShowToast(@StringRes val message: Int) : ChatSideEffect()
}