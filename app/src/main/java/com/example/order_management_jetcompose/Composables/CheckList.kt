package com.example.order_management_jetcompose.Composables

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import com.example.order_management_jetcompose.OrderAdd
import com.example.order_management_jetcompose.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun CheckList() {
    var uid = FirebaseAuth.getInstance().currentUser?.uid
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))

    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Your Order"
                ,fontSize = 25.sp
                ,fontWeight = FontWeight.Bold
                ,color = Color.White
                ,textAlign = TextAlign.Center
                ,modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center)
            )

            Image(painter = painterResource(id = R.drawable.search)
                , contentDescription = null,
                modifier = Modifier
                    .padding(250.dp, 0.dp, 0.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center) )

            Image(painter = painterResource(id = R.drawable.more)
                , contentDescription = null,
                modifier = Modifier
                    .padding(340.dp, 0.dp, 0.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center) )

        }

        Image(painter = painterResource(id = R.drawable.home_2)
            , contentDescription = null
            , modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally))
        Image(painter = painterResource(id = R.drawable.home_1)
            , contentDescription = null
            , modifier = Modifier
                .size(300.dp)
                .align(Alignment.CenterHorizontally))

        Box() {
            val context = LocalContext.current
            Button(
                onClick = {
                          if(uid != null){
                              context.startActivity(Intent(context,OrderAdd::class.java))
                          }
                    else
                          {
                              Toast.makeText(context,"First create Your Account",Toast.LENGTH_SHORT).show()
                          }

                },
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
                    .padding(150.dp,0.dp,0.dp,0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            ) {
                Text(text = "Add")
            }


        }

    }
}