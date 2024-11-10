package com.devocean.feature.chat.chatlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.component.button.TextButton
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.R
import com.devocean.feature.chat.chatlist.component.MyChatItem
import com.devocean.feature.chat.chatlist.component.MyPageTopBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChatListRoute(
    onBackClick: () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setNavigationBarColor(
            color = Color.White
        )
    }

    ChatListScreen(
        onBackClick = { onBackClick() }
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
        MyChatItem(text  = "오늘 날씨는 어떤가요?")
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview(){
    DevoceanSpotTheme {
        ChatListScreen()
    }
}