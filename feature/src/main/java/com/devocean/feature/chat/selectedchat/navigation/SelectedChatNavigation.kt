package com.devocean.feature.chat.selectedchat.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.devocean.core.navigation.Route
import com.devocean.feature.chat.selectedchat.SelectedChatRoute
import kotlinx.serialization.Serializable

fun NavController.navigateSelectedChat(
    id: Int,
    navOptions: NavOptions? = null
) {
    navigate(
        route = SelectedChat(id = id),
        navOptions = navOptions
    )
}

fun NavGraphBuilder.selectedChatNavGraph(
    navHostController: NavHostController,
) {
    composable<SelectedChat> {
        val args = it.toRoute<SelectedChat>()
        SelectedChatRoute(
            id = args.id,
            onBackClick = { navHostController.navigateUp() }
        )
    }
}

@Serializable
data class SelectedChat(
    val id: Int
) : Route