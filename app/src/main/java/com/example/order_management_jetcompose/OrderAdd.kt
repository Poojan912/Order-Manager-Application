package com.example.order_management_jetcompose

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.order_management_jetcompose.ui.theme.Order_management_jetComposeTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class OrderAdd : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Order_management_jetComposeTheme {
               OrderAddScreen()
            }
        }
    }
}
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun OrderAddScreen(){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.black))) {
var context = LocalContext.current





        val price = remember { mutableStateOf(TextFieldValue()) }
        val prepayment = remember { mutableStateOf(TextFieldValue()) }
        val primecost = remember { mutableStateOf(TextFieldValue()) }
        val Description = remember { mutableStateOf(TextFieldValue()) }
        val customer = remember { mutableStateOf(TextFieldValue()) }
        val location = remember { mutableStateOf(TextFieldValue()) }
        val date = remember { mutableStateOf("") }
        val time = remember { mutableStateOf(TextFieldValue()) }

        // date picking dialog

        val mYear: Int
        val mMonth: Int
        val mDay: Int

        // Initializing a Calendar
        val mCalendar = Calendar.getInstance()

        // Fetching current year, month and day
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

        mCalendar.time = Date()

        // Declaring a string value to
        // store date in string format


        // Declaring DatePickerDialog and setting
        // initial values as current values (present year, month and day)
        val mDatePickerDialog = DatePickerDialog(
            context,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                date.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            }, mYear, mMonth, mDay
        )


        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {

            var context = LocalContext.current

            Image(painter = painterResource(id = R.drawable.clear)
                , contentDescription = null,
                modifier = Modifier
                    .padding(0.dp, 0.dp, 320.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center))

            Text(text = "Add Order"
                ,fontSize = 25.sp
                ,fontWeight = FontWeight.Bold
                ,color = Color.White
                ,textAlign = TextAlign.Center
                ,modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.Center)
            )


            Image(painter = painterResource(id = R.drawable.check1)
                , contentDescription = null,
                modifier = Modifier.clickable {
                    var uid = FirebaseAuth.getInstance().currentUser!!.uid
                    val price1=price.value.text
                    val prepayment1=prepayment.value.text
                    val primecost1=primecost.value.text
                    val description1=Description.value.text
                    val location1=location.value.text
                    val customer1=customer.value.text
                    val date1=date.value
                    val time1=time.value.text
                    val mdref : DatabaseReference = FirebaseDatabase.getInstance().getReference()

                    if (uid != null) {
                        mdref.child("User").child(uid).child("order").push()
                            .setValue(Order(price1,prepayment1,primecost1,description1,location1,customer1,date1,time1,uid)).addOnSuccessListener {
                                context.startActivity(Intent(context,BottomBarScreen::class.java))
                            }
                    }




                }
                    .padding(320.dp, 0.dp, 0.dp, 0.dp)
                    .size(30.dp)
                    .align(Alignment.Center) )

        }

        Spacer(modifier = Modifier.height(50.dp))
        TextField(
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.gray), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = colorResource(id = R.color.white)),
            label = { Text(text = "Price", color = colorResource(id = R.color.gray)) },
            trailingIcon = {
                Image(painter = painterResource(id = R.drawable.price), contentDescription = null )
            },
            value = price.value,
            onValueChange = { price.value = it })

        Spacer(modifier = Modifier.height(15.dp))

        Box() {
            TextField(
                modifier = Modifier
                    .width(190.dp)
                    .padding(19.dp, 0.dp, 0.dp, 0.dp)
                    .background(Color.Black)
                    .border(color = colorResource(id = R.color.gray), width = 2.dp),
                colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
                trailingIcon = {
                    Image(painter = painterResource(id = R.drawable.hourglass), contentDescription = null )
                },
                label = { Text(text = "PrePayment", color = colorResource(id = R.color.gray)) },
                value = prepayment.value,
                onValueChange = { prepayment.value = it })
            TextField(
                modifier = Modifier
                    .width(1800.dp)
                    .padding(200.dp, 0.dp, 19.dp, 0.dp)
                    .background(Color.Black)
                    .border(color = colorResource(id = R.color.gray), width = 2.dp),
                colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
                label = { Text(text = "Prime Cost", color = colorResource(id = R.color.gray)) },
                trailingIcon = {
                    Image(painter = painterResource(id = R.drawable.primecost), contentDescription = null )
                },
                value = primecost.value,
                onValueChange = { primecost.value = it })

        }
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.gray), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Description", color = colorResource(id = R.color.gray)) },
            trailingIcon = {
                Image(painter = painterResource(id = R.drawable.description), contentDescription = null )
            },
            value = Description.value,
            onValueChange = { Description.value = it })
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.gray), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Customer", color = colorResource(id = R.color.gray)) },
            trailingIcon = {
                Image(painter = painterResource(id = R.drawable.person), contentDescription = null )
            },
            value = customer.value,
            onValueChange = { customer.value = it })
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            modifier = Modifier
                .width(350.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.Black)
                .border(color = colorResource(id = R.color.gray), width = 2.dp),
            colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
            label = { Text(text = "Location", color = colorResource(id = R.color.gray)) },
            trailingIcon = {
                Image(painter = painterResource(id = R.drawable.location), contentDescription = null )
            },
            value = location.value,
            onValueChange = { location.value = it })

        Spacer(modifier = Modifier.height(15.dp))

        Box() {
            TextField(
                modifier = Modifier
                    .width(180.dp).clickable {
                       mDatePickerDialog.show()
                    }
                    .padding(19.dp, 0.dp, 0.dp, 0.dp)
                    .background(Color.Black)
                    .border(color = colorResource(id = R.color.gray), width = 2.dp),

                colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
                label = { Text(text = "Date", color = colorResource(id = R.color.gray)) },
                trailingIcon = {
                    Image(painter = painterResource(id = R.drawable.date), contentDescription = null )
                },
                value = date.value,
                onValueChange = { date.value = it })
            TextField(
                modifier = Modifier
                    .width(1800.dp)
                    .padding(190.dp, 0.dp, 19.dp, 0.dp)
                    .background(Color.Black)
                    .border(color = colorResource(id = R.color.gray), width = 2.dp),
                colors = TextFieldDefaults.textFieldColors(textColor = Color.White),
                label = { Text(text = "Time", color = colorResource(id = R.color.gray)) },
                trailingIcon = {
                    Image(painter = painterResource(id = R.drawable.time), contentDescription = null )
                },
                value = time.value,
                onValueChange = { time.value = it })

        }
        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {

            },

            modifier = Modifier
                .width(350.dp)
                .height(40.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
        ) {
            Text(text = "Add Image")
        }




        
    }
    
    
    
}