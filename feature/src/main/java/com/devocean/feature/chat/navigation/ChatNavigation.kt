package com.devocean.feature.chat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devocean.core.navigation.MainTabRoute
import com.devocean.feature.chat.ChatRoute
import kotlinx.serialization.Serializable

fun NavController.navigateBookmark(navOptions: NavOptions? = null) {
    navigate(
        route = Chat,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.chatNavGraph(
    navHostController: NavHostController,
) {
    composable<Chat> {
        ChatRoute(
            navigateUp = { navHostController.navigateUp() }
        )
    }
}

@Serializable
data object Chat : MainTabRoute