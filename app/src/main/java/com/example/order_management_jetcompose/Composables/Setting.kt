package com.example.order_management_jetcompose.Composables


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.order_management_jetcompose.R

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun Setting() {

    var name1 by remember { mutableStateOf("") }
    var email1 by remember { mutableStateOf("") }
    val uid= FirebaseAuth.getInstance().currentUser?.uid

    var mdref : DatabaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(uid.toString())
    mdref.addValueEventListener(object : ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
           name1 = snapshot.child("name").value.toString()
            email1 = snapshot.child("email").value.toString()
        }

        override fun onCancelled(error: DatabaseError) {

        }

    })

    Column(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
    ) {
        Text(
            text = "Setting",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            textAlign = TextAlign.Center,
            fontSize = 34.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .height(100.dp)
            .background(colorResource(id = R.color.gray))
            .padding(20.dp)
            ,verticalArrangement = Arrangement.Center
            ,horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = name1 , color = colorResource(id = R.color.pink), fontSize = 20.sp)
            Text(
                text = email1 , color = Color.White, fontSize = 20.sp)

        }
        Spacer(modifier = Modifier.height(50.dp))

        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
              ) {
           Box() {

               Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

               Text(modifier = Modifier
                   .padding(50.dp, 0.dp, 0.dp, 0.dp)
                   .align(Alignment.Center),
                   text = "Customer" , color = Color.White, fontSize = 25.sp)
           }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxWidth()
            .height(40.dp)
            .background(colorResource(id = R.color.gray))
            ,verticalArrangement = Arrangement.Center
        ) {
            Box() {

                Image(painter = painterResource(id = R.drawable.tag), contentDescription = null, modifier = Modifier.size(40.dp))

                Text(modifier = Modifier
                    .padding(50.dp, 0.dp, 0.dp, 0.dp)
                    .align(Alignment.Center),
                    text = "Customer" , color = Color.White, fontSize = 25.sp)
            }

        }

    }
}