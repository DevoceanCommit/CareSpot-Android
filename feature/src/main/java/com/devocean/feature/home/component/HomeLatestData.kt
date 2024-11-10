package com.devocean.feature.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.component.item.ChatBotChatItem
import com.devocean.core.designsystem.component.item.MyChatItem
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.R

@Composable
fun HomeLatestData(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = SpotGray,
                shape = RoundedCornerShape(10.dp)
            )
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(R.string.home_latest_title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        MyChatItem(
            text = "I am talking",
            modifier = Modifier.align(Alignment.End)
        )
        ChatBotChatItem(text = "chat bot")
        MyChatItem(
            text = "I am leeeyubin",
            modifier = Modifier.align(Alignment.End)
        )
        ChatBotChatItem(text = "chat bot")
        MyChatItem(
            text = "Hello Devocean!",
            modifier = Modifier.align(Alignment.End)
        )
        ChatBotChatItem(text = "chat bot")
        MyChatItem(
            text = "I am Android",
            modifier = Modifier.align(Alignment.End)
        )
        ChatBotChatItem(text = "chat bot")
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeLatestDataPreview() {
    DevoceanSpotTheme {
        HomeLatestData()
    }
}