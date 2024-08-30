package com.groupec.railnavigationcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class Page(val title:String, val content: String){
    HOME("home","Show only icon"),
    SEARCH("Search","Show icon with label"),
    SETTINGS("Settings","Show icon /Show the label only when selected")
}

@Composable
fun NavigationRailSample() {
    var selectedItem by remember { mutableStateOf(0) }
    val pages = Page.values()
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    Row {
        NavigationRail {
            pages.forEachIndexed { index, item ->
                when(item){
                    Page.HOME -> {
                        NavigationRailItem(
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                    Page.SEARCH -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                    Page.SETTINGS -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        }

        Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(pages[selectedItem].content, Modifier.padding(start = 8.dp))
        }
    }
}
