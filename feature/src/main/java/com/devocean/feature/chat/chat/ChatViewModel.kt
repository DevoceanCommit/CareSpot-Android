package com.devocean.feature.chat.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
) : ViewModel() {
    private val _sideEffects = MutableSharedFlow<ChatSideEffect>()
    val sideEffects: SharedFlow<ChatSideEffect> get() = _sideEffects.asSharedFlow()


    fun navigateToChatList() =
        viewModelScope.launch { _sideEffects.emit(ChatSideEffect.NavigateToChatList) }
}