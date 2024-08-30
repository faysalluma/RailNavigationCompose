package com.groupec.railnavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.groupec.railnavigationcompose.ui.theme.RailNavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RailNavigationComposeTheme {
                MyAppNavigationRail()
                // NavigationRailSample()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RailNavigationComposeTheme {
        MyAppNavigationRail()
    }
}