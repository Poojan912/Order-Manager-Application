package com.example.order_management_jetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

class CheckList1Screen : ComponentActivity() {
    private val viewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
              CheckList1()

            }
        }
    }
}

