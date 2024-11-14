package com.devocean.feature.chat.selectedchat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.devocean.core.designsystem.component.item.ChatBotChatItem
import com.devocean.core.designsystem.component.item.MyChatItem
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.extension.toast
import com.devocean.feature.chat.selectedchat.component.SelectedChatTopBar
import com.devocean.feature.chat.selectedchat.component.SummaryDialog
import com.devocean.feature.chat.selectedchat.model.SelectedChatModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun SelectedChatRoute(
    id: Int,
    onBackClick: () -> Unit,
    viewModel: SelectedChatViewModel = hiltViewModel()
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    val action by viewModel.action.collectAsStateWithLifecycle()
    val state = viewModel.state.collectAsStateWithLifecycle()

    if (action) {
        SummaryDialog(
            onDismissRequest = { viewModel.updateSummaryDialog(false) },
            text = "이것은 한 줄 요약입니다."
        )
    }

    LaunchedEffect(true) {
        viewModel.getSelectedChat(sessionId = id)
    }


    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SelectedChatSideEffect.ShowToast -> context.toast(sideEffect.message)
                }
            }
    }

    SelectedChatScreen(
        selectedChat = state.value.chat,
        onBackClick = onBackClick,
        onDialogClick = { viewModel.updateSummaryDialog(true) }
    )
}

@Composable
fun SelectedChatScreen(
    selectedChat: PersistentList<SelectedChatModel>,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onDialogClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SelectedChatTopBar(
            onBackClick = onBackClick,
            onDialogClick = onDialogClick
        )
        LazyColumn(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(selectedChat) { item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                        .padding(bottom = 10.dp)
                ) {
                    when (item.type) {
                        AI -> {
                            ChatBotChatItem(
                                text = item.content,
                                modifier = Modifier.align(Alignment.Start)
                            )
                        }

                        USER -> {
                            MyChatItem(
                                text = item.content,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                    }
                }
            }
        }
    }
}

private const val AI = "ai"
private const val USER = "user"

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview() {
    DevoceanSpotTheme {
        SelectedChatScreen(
            onDialogClick = {},
            onBackClick = {},
            selectedChat = persistentListOf()
        )
    }
}