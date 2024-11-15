package com.devocean.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.R

@Composable
fun HomeProfile(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = com.devocean.core.R.drawable.ic_person_24),
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .aspectRatio(1f)
                .background(SpotGray),
            contentDescription = "profile image",
            tint = Color.White
        )
        Column(
            modifier = Modifier.padding(start = 5.dp)
        ) {
            Text(
                text = "김스팟",
                fontWeight = FontWeight.Bold,
            )
            Text(text = "나이 70세")
            Text(text = "서울 동작구")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeProfilePreview() {
    DevoceanSpotTheme {
        HomeProfile()
    }
}