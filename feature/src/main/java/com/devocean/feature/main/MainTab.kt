package com.devocean.feature.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import com.devocean.core.navigation.MainTabRoute
import com.devocean.feature.R
import com.devocean.feature.bookmark.navigation.Bookmark
import com.devocean.feature.home.navigation.Home

enum class MainTab(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: MainTabRoute,
) {
    HOME(
        selectedIcon = R.drawable.img_home_32,
        unselectedIcon = R.drawable.img_home_unselected_32,
        route = Home
    ),
    BOOKMARK(
        selectedIcon = R.drawable.ic_chat_24,
        unselectedIcon = R.drawable.ic_chat_24,
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
