package com.example.order_management_jetcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme

class popupPeriod : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
                popUpPeriod()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun popUpPeriod(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.white)), horizontalAlignment = Alignment.CenterHorizontally) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

            var context = LocalContext.current

            Image(painter = painterResource(id = R.drawable.clear1)
                , contentDescription = null,
                modifier = Modifier
                    .clickable {
                        context.startActivity(Intent(context, BottomBarScreen::class.java))
                    }
                    .padding(0.dp, 0.dp, 320.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center))

            Text(text = "Accounting period"
                ,fontSize = 25.sp
                ,fontWeight = FontWeight.Bold
                ,color = Color.Black
                ,textAlign = TextAlign.Center
                ,modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center)
            )


            Image(painter = painterResource(id = R.drawable.check)
                , contentDescription = null,
                modifier = Modifier
                    .clickable {
                        context.startActivity(Intent(context, BottomBarScreen.Constants::class.java))
                    }
                    .padding(320.dp, 0.dp, 0.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center) )

        }

        Spacer(modifier = Modifier.height(50.dp))
        
        Text(text = "Month", modifier = Modifier
            .padding(20.dp, 10.dp, 20.dp, 0.dp)
            .background(
                color = colorResource(
                    id = R.color.light
                )
            )
            .width(350.dp)
            .height(60.dp)
            .align(Alignment.CenterHorizontally), fontSize = 30.sp)

        Text(text = "Week", modifier = Modifier
            .padding(20.dp, 10.dp, 20.dp, 0.dp)
            .background(
                color = colorResource(
                    id = R.color.light
                )
            )
            .width(350.dp)
            .height(60.dp)
            .align(Alignment.CenterHorizontally), fontSize = 30.sp)

        Text(text = "Day", modifier = Modifier
            .padding(20.dp, 10.dp, 20.dp, 0.dp)
            .background(
                color = colorResource(
                    id = R.color.light
                )
            )
            .width(350.dp)
            .height(60.dp)
            .align(Alignment.CenterHorizontally), fontSize = 30.sp)

        Text(text = "Custom", modifier = Modifier
            .padding(20.dp, 10.dp, 20.dp, 0.dp)
            .background(
                color = colorResource(
                    id = R.color.light
                )
            )
            .width(350.dp)
            .height(60.dp), fontSize = 30.sp)

    }

}

