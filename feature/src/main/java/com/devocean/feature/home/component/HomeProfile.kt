package com.devocean.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.feature.R

@Composable
fun HomeProfile(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .aspectRatio(1f),
            contentDescription = "profile image"
        )
        Column(
            modifier = Modifier.padding(start = 5.dp)
        ) {
            Text(text = "어르신 1")
            Text(text = "나이 n세")
            Text(text = "서울 광진구")
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