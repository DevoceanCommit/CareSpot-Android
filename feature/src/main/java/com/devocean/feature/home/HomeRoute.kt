package com.devocean.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import com.devocean.core.designsystem.theme.SpotGray
import com.devocean.feature.home.component.HomeLatestData
import com.devocean.feature.home.component.HomeProfile
import com.devocean.feature.home.component.HomeSensorData
import com.devocean.feature.home.component.HomeTopBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White
        )
    }

    HomeScreen()
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        HomeTopBar()
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider(thickness = 2.dp, color = SpotGray)
        Spacer(modifier = Modifier.height(20.dp))
        HomeProfile(modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.height(30.dp))
        HomeSensorData()
        Spacer(modifier = Modifier.height(20.dp))
        HomeLatestData(
            modifier = Modifier.height(300.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    DevoceanSpotTheme {
        HomeScreen()
    }
}