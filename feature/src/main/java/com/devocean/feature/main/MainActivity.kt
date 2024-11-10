package com.devocean.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devocean.core.designsystem.theme.DevoceanSpotTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevoceanSpotTheme {
                val navigator: MainNavigator = rememberMainNavigator()

                MainScreen(
                    navigator = navigator,
                )
            }
        }
    }
}
