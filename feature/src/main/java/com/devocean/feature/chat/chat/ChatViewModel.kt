package com.devocean.feature.chat.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devocean.domain.repository.ChatRepository
import com.devocean.feature.R
import com.devocean.feature.chat.chat.model.toModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    private val _state: MutableStateFlow<ChatState> = MutableStateFlow(ChatState())
    val state: StateFlow<ChatState> = _state.asStateFlow()

    private val _sideEffects = MutableSharedFlow<ChatSideEffect>()
    val sideEffects: SharedFlow<ChatSideEffect> = _sideEffects.asSharedFlow()

    fun navigateToChatList(id: Int) =
        viewModelScope.launch { _sideEffects.emit(ChatSideEffect.NavigateToChatList(id)) }

    fun getChatList() {
        viewModelScope.launch {
            repository.getChatList()
                .onSuccess { chatList ->
                    _state.update { currentState ->
                        currentState.copy(chatList = chatList.map { it.toModel() }
                            .toPersistentList())
                    }
                }
                .onFailure {
                    _sideEffects.emit(ChatSideEffect.ShowToast(R.string.server_failure))
                }
        }
    }

}