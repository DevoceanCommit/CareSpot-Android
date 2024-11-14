package com.devocean.feature.chat.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devocean.domain.repository.ChatRepository
import com.devocean.feature.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    private val _sideEffects = MutableSharedFlow<ChatSideEffect>()
    val sideEffects: SharedFlow<ChatSideEffect> get() = _sideEffects.asSharedFlow()

    fun navigateToChatList() =
        viewModelScope.launch { _sideEffects.emit(ChatSideEffect.NavigateToChatList) }

    fun getChatList() {
        viewModelScope.launch {
            repository.getChatList()
                .onSuccess {
                    _sideEffects.emit(ChatSideEffect.ShowToast(R.string.server_success))
                }
                .onFailure {
                    _sideEffects.emit(ChatSideEffect.ShowToast(R.string.server_failure))
                }
        }
    }

}