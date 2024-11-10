package com.devocean.feature.chat.chatlist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotSub
import com.devocean.feature.R

@Composable
fun MyChatItem(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(SpotSub)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            painter = painterResource(R.drawable.ic_person_24),
            contentDescription = "my_profile",
            tint = Color.White,
            modifier = Modifier
                .clip(CircleShape)
                .background(SpotSub)
                .padding(5.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyChatItemPreview() {
    DevoceanSpotTheme {
        MyChatItem(
            text = "안녕하세요. 날씨가 어떤가요?"
        )
    }
}