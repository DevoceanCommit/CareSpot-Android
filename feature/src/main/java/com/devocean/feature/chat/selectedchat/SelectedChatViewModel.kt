package com.devocean.feature.chat.selectedchat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SelectedChatViewModel @Inject constructor(
) : ViewModel() {

    private val _action: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val action: StateFlow<Boolean> = _action.asStateFlow()

    fun updateSummaryDialog(visible: Boolean) {
        _action.update { visible }
    }

    fun getSelectedChat(sessionId: Int){

    }
}