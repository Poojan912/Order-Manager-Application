package com.example.order_management_jetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.order_management_jetcompose.Composables.LoginPage
import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
              LoginPage()
            }
        }
    }
}

