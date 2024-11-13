package com.devocean.feature.chat.chat

import androidx.annotation.StringRes

sealed class ChatSideEffect {
    data object NavigateToChatList : ChatSideEffect()
    data class ShowToast(@StringRes val message: Int) : ChatSideEffect()
}