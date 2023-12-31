package com.example.order_management_jetcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.order_management_jetcompose.Composables.LoginPage
import com.example.order_management_jetcompose.Composables.SignUpPage
import com.example.order_management_jetcompose.Composables.SplashScreen
import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
                OrderManagerApplication()
            }
        }
    }
    @Composable
    fun OrderManagerApplication() {
        SplashScreen()
    }

}

