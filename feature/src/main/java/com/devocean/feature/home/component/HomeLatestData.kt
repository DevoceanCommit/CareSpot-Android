package com.devocean.feature.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.devocean.feature.home.model.LatestChatListModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeLatestData(
    chatList: PersistentList<LatestChatListModel>,
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
    ) {
        Text(
            text = stringResource(R.string.home_latest_title),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp, start = 10.dp)
        )
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(chatList) { item ->
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
private fun HomeLatestDataPreview() {
    DevoceanSpotTheme {
        HomeLatestData(
            chatList = persistentListOf()
        )
    }
}