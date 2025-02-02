package com.devocean.feature.chat.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
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
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.core.extension.toast
import com.devocean.feature.chat.chat.component.ChatListItem
import com.devocean.feature.chat.chat.component.ChatTopBar
import com.devocean.feature.chat.chat.model.ChatListModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.collections.immutable.persistentListOf

@Composable
fun ChatRoute(
    paddingValues: PaddingValues,
    navigateToSelectedChat: (Int) -> Unit,
    viewModel: ChatViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    val state = viewModel.state.collectAsStateWithLifecycle()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    LaunchedEffect(true) {
        viewModel.getChatList()
    }

    LaunchedEffect(viewModel.sideEffects, lifecycleOwner) {
        viewModel.sideEffects.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is ChatSideEffect.NavigateToChatList -> navigateToSelectedChat(sideEffect.id)

                    is ChatSideEffect.ShowToast -> context.toast(sideEffect.message)

                }
            }
    }

    ChatScreen(
        paddingValues = paddingValues,
        dataList = state.value.chatList,
        onCLick = { viewModel.navigateToChatList(id = it) }
    )
}

@Composable
fun ChatScreen(
    dataList: List<ChatListModel>,
    onCLick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
    ) {
        ChatTopBar()
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider(thickness = 2.dp, color = SpotGray)
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(dataList) { item ->
                Box(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    ChatListItem(
                        summary = item.summary,
                        date = item.date,
                        modifier = Modifier.clickable { onCLick(item.id) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatScreenPreview() {
    DevoceanSpotTheme {
        val mockDataList = persistentListOf(
            ChatListModel(
                summary = "한줄요약",
                date = "2024-11-10 15:11",
                id = 1
            ),
            ChatListModel(
                summary = "한줄요약",
                date = "2024-11-10 15:11",
                id = 2
            )
        )
        ChatScreen(
            dataList = mockDataList,
            onCLick = {}
        )
    }
}