package com.devocean.feature.chat.chat

sealed class ChatSideEffect {
    data object NavigateToChatList : ChatSideEffect()
}