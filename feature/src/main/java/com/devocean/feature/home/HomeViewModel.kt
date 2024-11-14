package com.devocean.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devocean.domain.repository.HomeRepository
import com.devocean.feature.R
import com.devocean.feature.home.navigation.Home
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val _sideEffect: MutableSharedFlow<HomeSideEffect> = MutableSharedFlow()
    val sideEffect: SharedFlow<HomeSideEffect> = _sideEffect

    fun getLatestChat() {
        viewModelScope.launch {
            repository.getLatestChat()
                .onSuccess {
                    _sideEffect.emit(HomeSideEffect.ShowToast(R.string.server_success))
                }
                .onFailure {
                    _sideEffect.emit(HomeSideEffect.ShowToast(R.string.server_failure))
                }
        }
    }
}