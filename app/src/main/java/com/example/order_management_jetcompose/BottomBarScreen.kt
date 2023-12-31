package com.example.order_management_jetcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarScreen(
    val label: String,
    val icon: Int,
    val route:String,
){
    object Constants {
        val BottomBarScreen = listOf(
            BottomBarScreen(
                label = "Check List",
                icon = R.drawable.checklist,
                route = "checklist"
            ),
            BottomBarScreen(
                label = "Trend",
                icon = R.drawable.upward,
                route = "trend"
            ),
            BottomBarScreen(
                label = "Setting",
                icon = R.drawable.setting,
                route = "setting"
            )
        )
    }
}