package com.groupec.railnavigationcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home : NavigationScreen("home", "Home", Icons.Filled.Home)
    object Favorites : NavigationScreen("favorites", "Favorites", Icons.Filled.Favorite)
    object Settings : NavigationScreen("settings", "Settings", Icons.Filled.Settings)
}
