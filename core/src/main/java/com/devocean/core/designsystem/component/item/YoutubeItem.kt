package com.devocean.core.designsystem.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devocean.core.R
import com.devocean.core.designsystem.component.button.TextButton
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray

@Composable
fun YoutubeItem(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    category: String = "",
    summary: String,
    onCategoryClick: () -> Unit = {},
    isBookmark: Boolean = false,
    spotDate: String = "",
) {
    Column(
        modifier = modifier
            .background(
                color = SpotGray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(15.dp)
            .fillMaxSize(),
    ) {
        Image(
            image, contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            TextButton(
                paddingVertical = 0.dp,
                onButtonClick = { onCategoryClick() },
                text = category,
                modifier = modifier.size(width = 56.dp, height = 20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(text = spotDate)
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            if (isBookmark) Image(
                painter = painterResource(id = R.drawable.img_bookmark_32),
                contentDescription = "selected bookmark icon",
            )
            else Image(
                painter = painterResource(id = R.drawable.img_bookmark_unselected_32),
                contentDescription = "unselected bookmark icon",
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = summary)
    }
}

@Preview(showBackground = true)
@Composable
fun YoutubeItemPreview() {
    DevoceanSpotTheme {
        YoutubeItem(
            image = painterResource(id = R.drawable.img_youtube_default_pic),
            title = "데보션 영 3기 생생한 발대식 현장",
            category = "IT",
            isBookmark = false,
            summary = "한줄요약",
            spotDate = "spot date: 10/14"
        )
    }
}