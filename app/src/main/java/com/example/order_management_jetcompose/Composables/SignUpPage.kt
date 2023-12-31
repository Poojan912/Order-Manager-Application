package com.example.order_management_jetcompose.Composables

import android.content.Intent
import android.net.Uri
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
import androidx.core.content.ContextCompat
import com.example.order_management_jetcompose.Analysis
import com.example.order_management_jetcompose.Login
import com.example.order_management_jetcompose.R
import com.example.order_management_jetcompose.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun SignUpPage() {
    var fauth : FirebaseAuth = FirebaseAuth.getInstance()
    var context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            painter = painterResource(R.drawable.layer1),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

    }
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val email = remember { mutableStateOf(TextFieldValue()) }
        val cpassword = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            modifier = Modifier.padding(0.dp,85.dp,0.dp,20.dp),
            text = "Create Account!",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 40.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                color = Color.Yellow
            )
        )

        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.pink), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Username", color = Color.White) },
            value = username.value,
            onValueChange = { username.value = it })
        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.pink), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Email", color = Color.White) },
            value = email.value,
            onValueChange = { email.value = it })

        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.pink), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Password", color = Color.White)},
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(0.dp))
        TextField(
            modifier = Modifier
                .padding(5.dp)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.pink), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Confirm Password", color = Color.White)},
            value = cpassword.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { cpassword.value = it })

        Spacer(modifier = Modifier.height(0.dp))
        Box(modifier = Modifier.padding(35.dp, 10.dp, 35.dp, 10.dp)) {

            val context = LocalContext.current

            Button(
                onClick = {
                    var name = username.value.text
                    var emailid = email.value.text
                    var passwordid = password.value.text
                    var mdref : DatabaseReference = FirebaseDatabase.getInstance().getReference()


                   fauth.createUserWithEmailAndPassword(emailid, passwordid)

                        .addOnCompleteListener() { task ->
                            if (task.isSuccessful) {
                                var uid = FirebaseAuth.getInstance().currentUser!!.uid

                                mdref.child("User").child(uid).setValue(User(name,emailid, uid))
                                context.startActivity(Intent(context,Login::class.java))

                            } else {
                                Toast.makeText(context, "Some Error Ocurred", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            ) {
                Text(text = "Sign Up")
            }
        }
        Spacer(modifier = Modifier.height(0.dp))
        val context = LocalContext.current
        Text(
            modifier = Modifier.padding(80.dp,0.dp,80.dp,0.dp),
            text = "Have an account? " , color = Color.White)
        Text(
            modifier = Modifier.padding(0.dp,0.dp,0.dp,10.dp).clickable {
                context.startActivity(Intent(context,Login::class.java))
            },
            text = "Login Here " , color = Color.Yellow)

        Spacer(modifier = Modifier.height(0.dp))
        Box(modifier = Modifier.padding(35.dp, 10.dp, 35.dp, 10.dp)) {
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

