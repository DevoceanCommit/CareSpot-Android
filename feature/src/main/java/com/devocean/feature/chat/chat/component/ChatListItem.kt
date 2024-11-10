package com.devocean.feature.chat.chat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray

@Composable
fun ChatListItem(
    modifier: Modifier = Modifier,
    title: String,
    date: String,
    summary: String,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(color = SpotGray)
            .padding(15.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = date)
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = summary)
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatListItemPreview() {
    DevoceanSpotTheme {
        ChatListItem(
            title = "데보션 영 3기 생생한 발대식 현장",
            date = "2024-11-10 15:11",
            summary = "한줄요약",
        )
    }
}