package com.devocean.feature.chat.selectedchat

import androidx.annotation.StringRes

sealed class SelectedChatSideEffect {
    data class ShowToast(@StringRes val message: Int) : SelectedChatSideEffect()
}