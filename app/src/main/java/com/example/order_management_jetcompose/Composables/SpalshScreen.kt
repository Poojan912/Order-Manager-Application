package com.example.order_management_jetcompose.Composables

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.order_management_jetcompose.R
import com.example.order_management_jetcompose.SignUp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun SplashScreen() {

    val SPLASH_SCREEN_TIME_OUT = 2000
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


        ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.layer1),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(0.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(100.dp, 0.dp, 0.dp, 0.dp),
            painter = painterResource(R.drawable.spalsh),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

    }
    Handler().postDelayed(Runnable {
        context.startActivity(Intent(context, SignUp::class.java))

    }, SPLASH_SCREEN_TIME_OUT.toLong())


}