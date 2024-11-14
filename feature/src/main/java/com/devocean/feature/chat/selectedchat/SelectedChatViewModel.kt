package com.devocean.feature.chat.selectedchat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devocean.domain.repository.ChatRepository
import com.devocean.feature.R
import com.devocean.feature.chat.chat.ChatSideEffect
import dagger.hilt.android.lifecycle.HiltViewModel
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

    private val _sideEffect = MutableSharedFlow<SelectedChatSideEffect>()
    val sideEffect: SharedFlow<SelectedChatSideEffect> = _sideEffect.asSharedFlow()

    fun updateSummaryDialog(visible: Boolean) {
        _action.update { visible }
    }

    fun getSelectedChat(sessionId: Int) {
        viewModelScope.launch {
            repository.getSelectedChat(sessionId)
                .onSuccess {
                    _sideEffect.emit(SelectedChatSideEffect.ShowToast(R.string.server_success))
                }
                .onFailure {
                    _sideEffect.emit(SelectedChatSideEffect.ShowToast(R.string.server_failure))
                }
        }
    }
}