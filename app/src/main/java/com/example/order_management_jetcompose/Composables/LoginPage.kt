package com.example.order_management_jetcompose.Composables



import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.order_management_jetcompose.*
import com.example.order_management_jetcompose.R


import com.google.firebase.auth.FirebaseAuth

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun LoginPage() {
    var context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            painter = painterResource(R.drawable.layer1),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

    }
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val email = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            modifier = Modifier.padding(10.dp,95.dp,20.dp,20.dp),
            text = "Login Account!",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 40.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color.Yellow
            )
        )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier
                .padding(20.dp)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.pink), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Email", color = Color.White) },
            value = email.value,
            onValueChange = { email.value = it })

        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.pink), width = 2.dp),
            label = { Text(text = "Password", color = Color.White)},
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(0.dp))
        Text(
            modifier = Modifier.padding(160.dp,0.dp,0.dp,0.dp),
            text = "forgot Password ?" , color = Color.White)

        Spacer(modifier = Modifier.height(0.dp))
        Box(modifier = Modifier.padding(35.dp, 30.dp, 35.dp, 10.dp)) {
            val mContext = LocalContext.current
            val emailid = email.value.text
            val passwordid =  password.value.text
            Button(
                onClick = {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(emailid, passwordid)
                        .addOnCompleteListener() { task ->
                            if (task.isSuccessful) {
                                mContext.startActivity(Intent(mContext,Analysis::class.java))
                            } else {
                                Toast.makeText(mContext,"User Does Not Exist", Toast.LENGTH_SHORT).show()
                            }
                        }


                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            ) {
                Text(text = "Login")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        val mContext = LocalContext.current
        Text(

            modifier = Modifier.padding(80.dp,0.dp,80.dp,0.dp),
            text = "Don't have an account? " , color = Color.White)
        Text(
            modifier = Modifier
                .padding(20.dp, 0.dp, 0.dp, 10.dp)
                .clickable {
                    mContext.startActivity(Intent(mContext, SignUp::class.java))
                },
            text = "Register " , color = Color.Yellow)

        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.padding(35.dp, 30.dp, 35.dp, 10.dp)) {
            Button(
                onClick = {
                       context.startActivity(Intent(context,Analysis::class.java))
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
            ) {
                Text(text = "Explore")
            }
        }

    }
}

