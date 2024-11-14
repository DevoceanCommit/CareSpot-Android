package com.devocean.feature.chat.selectedchat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devocean.domain.repository.ChatRepository
import com.devocean.feature.R
import com.devocean.feature.chat.selectedchat.model.toSelectedChatModel
import com.devocean.feature.chat.selectedchat.model.toSummaryReportModel
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
class SelectedChatViewModel @Inject constructor(
    private val repository: ChatRepository
) : ViewModel() {

    private val _action: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val action: StateFlow<Boolean> = _action.asStateFlow()

    private val _state: MutableStateFlow<SelectedChatState> = MutableStateFlow(SelectedChatState())
    val state: StateFlow<SelectedChatState> = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SelectedChatSideEffect>()
    val sideEffect: SharedFlow<SelectedChatSideEffect> = _sideEffect.asSharedFlow()

    fun updateSummaryDialog(visible: Boolean) {
        _action.update { visible }
    }

    fun getSelectedChat(sessionId: Int) {
        viewModelScope.launch {
            repository.getSelectedChat(sessionId)
                .onSuccess { chat ->
                    _state.update { currentState ->
                        currentState.copy(chat = chat.map { it.toSelectedChatModel() }
                            .toPersistentList())
                    }
                }
                .onFailure {
                    _sideEffect.emit(SelectedChatSideEffect.ShowToast(R.string.server_failure))
                }
        }
    }

    fun getSummaryReport(sessionId: Int) {
        viewModelScope.launch {
            repository.getSummaryReport(sessionId)
                .onSuccess { summary ->
                    _sideEffect.emit(SelectedChatSideEffect.ShowToast(R.string.server_success))

                    _state.update { currentState ->
                        currentState.copy(summary = summary.map { it.toSummaryReportModel() }
                            .toPersistentList())
                    }
                }
                .onFailure {
                    _sideEffect.emit(SelectedChatSideEffect.ShowToast(R.string.server_failure))
                }
        }
    }
}