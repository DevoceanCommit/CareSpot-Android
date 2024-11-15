package com.devocean.core.designsystem.component.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.R
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray

@Composable
fun ChatBotChatItem(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_person_24),
            contentDescription = "my_profile",
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(SpotGray)
                .padding(5.dp),
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(SpotGray)
                .padding(10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatBotChatItemPreview() {
    DevoceanSpotTheme {
        ChatBotChatItem(
            text = "오늘은 맑고 온도는 25도입니다."
        )
    }
}