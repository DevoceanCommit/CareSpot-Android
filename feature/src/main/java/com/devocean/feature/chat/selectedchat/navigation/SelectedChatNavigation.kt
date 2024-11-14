package com.devocean.feature.chat.selectedchat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devocean.core.navigation.Route
import com.devocean.feature.chat.selectedchat.SelectedChatRoute
import kotlinx.serialization.Serializable

fun NavController.navigateSelectedChat(navOptions: NavOptions? = null) {
    navigate(
        route = ChatList,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.selectedChatNavGraph(
    navHostController: NavHostController,
) {
    composable<ChatList> {
        SelectedChatRoute(
            onBackClick = { navHostController.navigateUp() }
        )
    }
}

@Serializable
data object ChatList : Route