package com.devocean.feature.chat.chatlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.devocean.core.designsystem.component.button.ImageButton
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotSub
import com.devocean.feature.R
import com.devocean.feature.chat.chatlist.component.ChatBotChatItem
import com.devocean.feature.chat.chatlist.component.MyChatItem
import com.devocean.feature.chat.chatlist.component.MyPageTopBar
import com.devocean.feature.chat.chatlist.component.SummaryDialog

@Composable
fun ChatListRoute(
    onBackClick: () -> Unit,
    viewModel: ChatListViewModel = hiltViewModel()
) {

    val action by viewModel.action.collectAsStateWithLifecycle()

    if (action == true) {
        SummaryDialog(
            onDismissRequest = { viewModel.updateSummaryDialog(false) },
            text = "이것은 한 줄 요약입니다."
        )
    }

    ChatListScreen(
        onBackClick = onBackClick,
        onDialogClick = { viewModel.updateSummaryDialog(true) }
    )
}

@Composable
fun ChatListScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onDialogClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        MyPageTopBar(onBackClick = onBackClick)
        MyChatItem(
            text = "오늘 날씨는 어떤가요?",
            modifier = Modifier
                .align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(10.dp))
        ChatBotChatItem(text = "오늘은 맑고 온도는 25도입니다.")
        Spacer(modifier = Modifier.weight(5f))
        ImageButton(
            paddingVertical = 10.dp,
            onButtonClick = onDialogClick,
            painterResource = R.drawable.ic_notes_24,
            containerColor = SpotSub,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview() {
    DevoceanSpotTheme {
        ChatListScreen(
            onDialogClick = {},
            onBackClick = {}
        )
    }
}