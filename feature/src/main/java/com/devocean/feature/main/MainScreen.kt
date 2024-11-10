package com.devocean.feature.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import com.devocean.core.designsystem.theme.SpotSub
import com.devocean.core.util.NoRippleInteractionSource
import com.devocean.feature.bookmark.navigation.bookmarkNavGraph
import com.devocean.feature.home.navigation.homeNavGraph
import com.devocean.feature.mypage.navigation.myPageNavGraph

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
    onPlusDialogClick: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            Box {
                MainBottomBar(
                    isVisible = navigator.showBottomBar(),
                    tabs = MainTab.entries.toList(),
                    currentTab = navigator.currentTab,
                    onTabSelected = navigator::navigate
                )
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            NavHost(
                navController = navigator.navController,
                startDestination = navigator.startDestination
            ) {
                homeNavGraph(navHostController = navigator.navController)
                bookmarkNavGraph(navHostController = navigator.navController)
                myPageNavGraph(navHostController = navigator.navController)
            }
        }
    }
}

@Composable
private fun MainBottomBar(
    isVisible: Boolean,
    tabs: List<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = expandVertically(expandFrom = Alignment.Top) { 20 },
        exit = shrinkVertically(animationSpec = tween()) { fullHeight ->
            fullHeight / 2
        },
    ) {
        NavigationBar(containerColor = SpotSub) {
            tabs.forEach { itemType ->
                NavigationBarItem(
                    interactionSource = NoRippleInteractionSource,
                    selected = currentTab == itemType,
                    onClick = {
                        onTabSelected(itemType)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = if (currentTab == itemType) itemType.selectedIcon
                                else itemType.unselectedIcon
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(23.dp)
                        )
                    },
                    colors = androidx.compose.material3.NavigationBarItemDefaults
                        .colors(
                            selectedIconColor = Color.Black,
                            unselectedIconColor = Color.Black,
                            indicatorColor = SpotSub
                        )
                )
            }
        }
    }
}