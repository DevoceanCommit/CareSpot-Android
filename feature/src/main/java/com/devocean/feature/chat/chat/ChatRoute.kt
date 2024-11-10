package com.devocean.feature.chat.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.chat.chat.component.ChatLIstItem
import com.devocean.feature.chat.chat.component.ChatTopBar
import com.devocean.feature.chat.chat.model.ChatListModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChatRoute(
    navigateToChatList: () -> Unit,
    viewModel: ChatViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    val lifecycleOwner = LocalLifecycleOwner.current

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    LaunchedEffect(viewModel.sideEffects, lifecycleOwner) {
        viewModel.sideEffects.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is ChatSideEffect.NavigateToChatList -> {
                        navigateToChatList()
                    }
                }
            }
    }

    val mockDataList = listOf(
        ChatListModel(
            title = "데보션 영 3기 생생한 발대식 현장",
            date = "2024-11-10 15:11",
            summary = "한줄요약"
        ),
        ChatListModel(
            title = "나는 왜 코프링 컨트롤러를 더이상 만들지 않게 되었나?",
            date = "2024-11-10 15:11",
            summary = "한줄요약"
        )
    )

    ChatScreen(
        dataList = mockDataList,
        onCLick = viewModel::navigateToChatList
    )
}

@Composable
fun ChatScreen(
    dataList: List<ChatListModel>,
    onCLick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
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
                    ChatLIstItem(
                        title = item.title,
                        date = item.date,
                        summary = item.summary,
                        modifier = Modifier.clickable { onCLick() }
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
        val mockDataList = listOf(
            ChatListModel(
                title = "데보션 영 3기 생생한 발대식 현장",
                date = "2024-11-10 15:11",
                summary = "한줄요약"
            ),
            ChatListModel(
                title = "나는 왜 코프링 컨트롤러를 더이상 만들지 않게 되었나?",
                date = "2024-11-10 15:11",
                summary = "한줄요약"
            )
        )
        ChatScreen(
            dataList = mockDataList,
            onCLick = {}
        )
    }
}