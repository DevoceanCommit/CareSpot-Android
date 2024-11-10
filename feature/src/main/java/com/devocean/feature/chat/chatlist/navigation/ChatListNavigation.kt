package com.devocean.feature.chat.chatlist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.devocean.core.navigation.Route
import com.devocean.feature.chat.chatlist.ChatListRoute
import kotlinx.serialization.Serializable

fun NavController.navigateChatList(navOptions: NavOptions? = null) {
    navigate(
        route = ChatList,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.chatListNavGraph(
    navHostController: NavHostController,
) {
    composable<ChatList> {
        ChatListRoute(
            onBackClick = { navHostController.navigateUp() }
        )
    }
}

@Serializable
data object ChatList : Route