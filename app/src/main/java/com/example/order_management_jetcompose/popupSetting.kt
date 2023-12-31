package com.example.order_management_jetcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class popupSetting : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
            Setting()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Setting(){
    val checkedState = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
    val checkedState3 = remember { mutableStateOf(false) }
    val checkedState4 = remember { mutableStateOf(false) }
    val checkedState5 = remember { mutableStateOf(false) }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.white))) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

            var context = LocalContext.current

            Image(painter = painterResource(id = R.drawable.back)
                , contentDescription = null,
                modifier = Modifier.clickable {
                    context.startActivity(Intent(context,Analysis::class.java))
                }
                    .padding(0.dp, 0.dp, 320.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center))

            Text(text = "Setting"
                ,fontSize = 25.sp
                ,fontWeight = FontWeight.Bold
                ,color = Color.Black
                ,textAlign = TextAlign.Center
                ,modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center)
            )


            Image(painter = painterResource(id = R.drawable.right)
                , contentDescription = null,
                modifier = Modifier.clickable {
                    context.startActivity(Intent(context,Analysis::class.java))
                }
                    .padding(320.dp, 0.dp, 0.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center) )

        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(modifier = Modifier
            .height(60.dp)
            .width(350.dp)
            .align(Alignment.CenterHorizontally)
            .background(colorResource(id = R.color.light))
        ) {
            Checkbox(
                checked = checkedState.value,
                modifier = Modifier
                    .padding(16.dp),
                onCheckedChange = { checkedState.value = it},
                colors = CheckboxDefaults.colors(colorResource(id = R.color.pink))
            )

            Text(text = "Profit and Proceeds", modifier = Modifier.padding(20.dp), color = Color.Black)
        }

         Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .height(60.dp)
            .width(350.dp)
            .align(Alignment.CenterHorizontally)
            .background(colorResource(id = R.color.light))
        ) {
            Checkbox(
                checked = checkedState2.value,
                modifier = Modifier
                    .padding(16.dp),
                onCheckedChange = { checkedState2.value = it},
                colors = CheckboxDefaults.colors(colorResource(id = R.color.pink))
            )

            Text(text = "Order Quality", modifier = Modifier.padding(20.dp), color = Color.Black)
        }


        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .height(60.dp)
            .width(350.dp)
            .align(Alignment.CenterHorizontally)
            .background(colorResource(id = R.color.light))
        ) {
            Checkbox(
                checked = checkedState3.value,
                modifier = Modifier
                    .padding(16.dp),
                onCheckedChange = { checkedState3.value = it},
                colors = CheckboxDefaults.colors(colorResource(id = R.color.pink))
            )

            Text(text = "Product Cateegory", modifier = Modifier.padding(20.dp), color = Color.Black)
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier
            .height(60.dp)
            .width(350.dp)
            .align(Alignment.CenterHorizontally)
            .background(colorResource(id = R.color.light))
        ) {
            Checkbox(
                checked = checkedState4.value,
                modifier = Modifier
                    .padding(16.dp),
                onCheckedChange = { checkedState4.value = it},
                colors = CheckboxDefaults.colors(colorResource(id = R.color.pink))
            )

            Text(text = "Customer Report", modifier = Modifier.padding(20.dp), color = Color.Black)
        }


        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .height(60.dp)
            .width(350.dp)
            .align(Alignment.CenterHorizontally)
            .background(colorResource(id = R.color.light))
        ) {
            Checkbox(
                checked = checkedState5.value,
                modifier = Modifier
                    .padding(16.dp),
                onCheckedChange = { checkedState5.value = it},
                colors = CheckboxDefaults.colors(colorResource(id = R.color.pink))
            )

            Text(text = "Top 3 Customer", modifier = Modifier.padding(20.dp), color = Color.Black)
        }

    }
}

