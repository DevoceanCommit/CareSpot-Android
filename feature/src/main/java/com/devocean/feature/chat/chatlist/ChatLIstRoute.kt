package com.devocean.feature.chat.chatlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.component.button.ImageButton
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotSub
import com.devocean.feature.R
import com.devocean.feature.chat.chatlist.component.ChatBotChatItem
import com.devocean.feature.chat.chatlist.component.MyChatItem
import com.devocean.feature.chat.chatlist.component.MyPageTopBar

@Composable
fun ChatListRoute(
    onBackClick: () -> Unit
) {

    ChatListScreen(
        onBackClick = onBackClick
    )
}

@Composable
fun ChatListScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
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
            onButtonClick = {},
            painterResource = R.drawable.ic_add_24,
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
        ChatListScreen()
    }
}