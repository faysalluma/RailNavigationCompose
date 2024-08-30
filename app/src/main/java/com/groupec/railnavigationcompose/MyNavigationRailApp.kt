package com.groupec.railnavigationcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppNavigationRail() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text("Navigation Rail Example") }) },
        content = { innerPadding ->
            Row (modifier = Modifier.padding(innerPadding)) {
                MyNavigationRail(navController)
                NavHost(
                    navController = navController,
                    startDestination = NavigationScreen.Home.route,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    composable(NavigationScreen.Home.route) { HomeScreen() }
                    composable(NavigationScreen.Favorites.route) { FavoriteScreen() }
                    composable(NavigationScreen.Settings.route) { SettingScreen() }
                }
            }
        }
    )
}

@Composable
fun MyNavigationRail(navController: NavController) {
    var selectedItem by remember { mutableStateOf(NavigationScreen.Home.route) }
    val items = listOf(
        NavigationScreen.Home,
        NavigationScreen.Favorites,
        NavigationScreen.Settings
    )

    NavigationRail {
        items.forEach { item ->
            NavigationRailItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = selectedItem == item.route,
                onClick = {
                    if (selectedItem != item.route) {
                        selectedItem = item.route
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}