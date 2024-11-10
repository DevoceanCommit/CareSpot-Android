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
        MyPageTopBar(
            onBackClick = { onBackClick() }
        )
        Divider(thickness = 2.dp, color = SpotGray)
        Spacer(modifier = modifier.weight(1f))
        TextButton(
            text = "A",
            onButtonClick = {},
            modifier = modifier
                .size(width = 90.dp, height = 90.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = modifier.weight(1f))
        Divider(thickness = 2.dp, color = SpotGray)
        Text(
            text = stringResource(id = R.string.mypage_name),
            modifier = modifier.padding(
                top = 20.dp,
                start = 20.dp
            ),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "김데보션",
            modifier = modifier.padding(
                top = 20.dp,
                start = 20.dp
            )
        )
        Text(
            text = stringResource(id = R.string.mypage_description),
            modifier = modifier.padding(
                top = 20.dp,
                start = 20.dp
            ),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "데보션영 파이팅~",
            modifier = modifier.padding(
                top = 20.dp,
                start = 20.dp
            )
        )
        Text(
            text = stringResource(id = R.string.mypage_bookmark),
            modifier = modifier.padding(
                top = 20.dp,
                start = 20.dp
            ),
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = modifier.weight(1f))
        Divider(thickness = 2.dp, color = SpotGray)
        Spacer(modifier = modifier.weight(2f))
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListScreenPreview(){
    DevoceanSpotTheme {
        ChatListScreen()
    }
}