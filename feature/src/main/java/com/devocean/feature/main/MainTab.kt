package com.devocean.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.devocean.core.navigation.MainTabRoute
import com.devocean.feature.R
import com.devocean.feature.bookmark.navigation.Bookmark
import com.devocean.feature.home.navigation.Home

enum class MainTab(
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int,
    val route: MainTabRoute,
) {
    HOME(
        icon = R.drawable.ic_home_24,
        contentDescription = R.string.bottom_nav_home,
        route = Home
    ),
    CHAT(
        icon = R.drawable.ic_chat_24,
        contentDescription = R.string.bottom_nav_chat,
        route = Bookmark
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
