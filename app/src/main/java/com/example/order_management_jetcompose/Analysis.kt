package com.example.order_management_jetcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.order_management_jetcompose.Composables.AnalysisScreen
import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme


class Analysis : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
                AnalysisScreen()
            }
        }
    }
}



