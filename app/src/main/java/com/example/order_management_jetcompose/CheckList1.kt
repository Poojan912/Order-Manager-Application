package com.example.order_management_jetcompose

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showSystemUi = true , showBackground = true)
@Composable
fun CheckList1(){
     Column(modifier = Modifier
          .fillMaxSize()
          .background(Color.Black)) {

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

          Text(text = "Today", modifier = Modifier.padding(20.dp,0.dp,0.dp,0.dp), color = Color.White)
          Spacer(modifier = Modifier.height(10.dp))
          
          Column(modifier = Modifier
               .height(150.dp)
               .width(350.dp)
               .align(Alignment.CenterHorizontally)
               .background(
                    color = colorResource(
                         id = R.color.gray
                    )
               )) {

               Box(modifier = Modifier.fillMaxWidth()){

                    Text(text = "Discription of the any type of text...", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Text(text = "+56.00$", modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 12.sp)


               }

               Box(modifier = Modifier.fillMaxWidth()){

                   Icon(painter = painterResource(id = R.drawable.time), contentDescription = null, modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp))

                    Text(text = "12:00 AM", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(40.dp, 8.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Icon(painter = painterResource(id = R.drawable.location1), contentDescription = null, modifier = Modifier.padding(100.dp, 5.dp, 10.dp, 0.dp))

                    Text(text = "india", modifier = Modifier
                         .padding(130.dp, 8.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Text(text = "000003", modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 12.sp)

               }
               Spacer(modifier = Modifier.height(5.dp))
               Box(modifier = Modifier.fillMaxWidth()){

                    Text(text = "No Tag", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp, 0.dp, 10.dp, 0.dp), color = Color.White, fontSize = 18.sp)

               }
               Spacer(modifier = Modifier.height(10.dp))
               Box(modifier = Modifier.fillMaxWidth()){

                    Button(onClick = {}, modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp), colors =  ButtonDefaults.buttonColors(backgroundColor = colorResource(
                         id = R.color.gray_light
                    ))) {
                         Icon(painter = painterResource(id = R.drawable.call), contentDescription = null )
                         Text(text = "ZoyaMark", modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp))
                    }
                    Icon(painter = painterResource(id = R.drawable.card), contentDescription = null, modifier = Modifier.padding(250.dp, 15.dp, 10.dp, 0.dp))

                    Text(text = "Credit Card", modifier = Modifier
                         .padding(280.dp, 17.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)


                    

               }
               
          }
          Spacer(modifier = Modifier.height(5.dp))

          Column(modifier = Modifier
               .height(150.dp)
               .width(350.dp)
               .align(Alignment.CenterHorizontally)
               .background(
                    color = colorResource(
                         id = R.color.gray
                    )
               )) {
               Box(modifier = Modifier.fillMaxWidth()){

                    Text(text = "Discription of the any type of text...", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Text(text = "+56.00$", modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 12.sp)


               }

               Box(modifier = Modifier.fillMaxWidth()){

                    Icon(painter = painterResource(id = R.drawable.time), contentDescription = null, modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp))

                    Text(text = "12:00 AM", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(40.dp, 8.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Icon(painter = painterResource(id = R.drawable.location1), contentDescription = null, modifier = Modifier.padding(100.dp, 5.dp, 10.dp, 0.dp))

                    Text(text = "india", modifier = Modifier
                         .padding(130.dp, 8.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Text(text = "000003", modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 12.sp)

               }
               Spacer(modifier = Modifier.height(5.dp))
               Box(modifier = Modifier.fillMaxWidth()){

                    Text(text = "No Tag", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp, 0.dp, 10.dp, 0.dp), color = Color.White, fontSize = 18.sp)

               }
               Spacer(modifier = Modifier.height(10.dp))
               Box(modifier = Modifier.fillMaxWidth()){

                    Button(onClick = {}, modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp), colors =  ButtonDefaults.buttonColors(backgroundColor = colorResource(
                         id = R.color.gray_light
                    ))) {
                         Icon(painter = painterResource(id = R.drawable.call), contentDescription = null )
                         Text(text = "ZoyaMark", modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp))
                    }
                    Icon(painter = painterResource(id = R.drawable.card), contentDescription = null, modifier = Modifier.padding(250.dp, 15.dp, 10.dp, 0.dp))

                    Text(text = "Credit Card", modifier = Modifier
                         .padding(280.dp, 17.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)




               }

          }
          Spacer(modifier = Modifier.height(10.dp))
          Text(text = "Today", modifier = Modifier.padding(20.dp,0.dp,0.dp,0.dp), color = Color.White)
          Spacer(modifier = Modifier.height(10.dp))
          Column(modifier = Modifier
               .height(150.dp)
               .width(350.dp)
               .align(Alignment.CenterHorizontally)
               .background(
                    color = colorResource(
                         id = R.color.gray
                    )
               )) {
               Box(modifier = Modifier.fillMaxWidth()){

                    Text(text = "Discription of the any type of text...", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Text(text = "+56.00$", modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 12.sp)


               }

               Box(modifier = Modifier.fillMaxWidth()){

                    Icon(painter = painterResource(id = R.drawable.time), contentDescription = null, modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 0.dp))

                    Text(text = "12:00 AM", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(40.dp, 8.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Icon(painter = painterResource(id = R.drawable.location1), contentDescription = null, modifier = Modifier.padding(100.dp, 5.dp, 10.dp, 0.dp))

                    Text(text = "india", modifier = Modifier
                         .padding(130.dp, 8.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

                    Text(text = "000003", modifier = Modifier
                         .align(Alignment.TopEnd)
                         .padding(10.dp, 5.dp, 10.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 12.sp)

               }
               Spacer(modifier = Modifier.height(5.dp))
               Box(modifier = Modifier.fillMaxWidth()){

                    Text(text = "No Tag", modifier = Modifier
                         .align(Alignment.TopStart)
                         .padding(10.dp, 0.dp, 10.dp, 0.dp), color = Color.White, fontSize = 18.sp)

               }
               Spacer(modifier = Modifier.height(10.dp))
               Box(modifier = Modifier.fillMaxWidth()){

                    Button(onClick = {}, modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp), colors =  ButtonDefaults.buttonColors(backgroundColor = colorResource(
                         id = R.color.gray_light
                    ))) {
                         Icon(painter = painterResource(id = R.drawable.call), contentDescription = null )
                         Text(text = "ZoyaMark", modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp))
                    }
                    Icon(painter = painterResource(id = R.drawable.card), contentDescription = null, modifier = Modifier.padding(250.dp, 15.dp, 10.dp, 0.dp))

                    Text(text = "Credit Card", modifier = Modifier
                         .padding(280.dp, 17.dp, 10.dp, 0.dp), color = Color.White, fontSize = 12.sp)

               }
          }
          Spacer(modifier = Modifier.height(50.dp))
          val context = LocalContext.current
          Button(
               onClick = {
                    context.startActivity(Intent(context,OrderAdd::class.java))
               },
               shape = RoundedCornerShape(40.dp),
               modifier = Modifier
                    .width(250.dp)
                    .height(50.dp)
                    .padding(150.dp, 0.dp, 0.dp, 0.dp),
               colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
          ) {
               Text(text = "Add")
          }








//          Scaffold(
//               content = {
//                    BarkHomeContent()
//               }
          //)
     }
}

//@Composable
//fun BarkHomeContent(){
//     val orders = remember { OrderGetter.getOrder() }
//     LazyColumn(
//          contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
//     ) {
//          items(
//               items = orders,
//               itemContent = {
//                    OrderListItem(order = it)
//               })
//     }
//}
//
//@Composable
//fun OrderListItem(order: Order){
//     Row {
//          Column {
//               Text(text = order.price.toString(), style = typography.h6)
//               Text(text = "VIEW DETAIL", style = typography.caption)
//          }
//     }
//
//}