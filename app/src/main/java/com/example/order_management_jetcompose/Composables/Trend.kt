package com.example.order_management_jetcompose.Composables


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.example.order_management_jetcompose.*
import com.example.order_management_jetcompose.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Trend() {
    var context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
    ) {
       Box(modifier = Modifier.fillMaxWidth()) {
           Text(text = "Analysis"
           ,fontSize = 30.sp
           ,fontWeight = FontWeight.Bold
           ,color = Color.White
           ,textAlign = TextAlign.Center
           ,modifier = Modifier
                   .padding(20.dp)
                   .align(Alignment.Center)
           )

          Image(painter = painterResource(id = R.drawable.delete)
              , contentDescription = null,
              modifier = Modifier
                  .padding(230.dp, 0.dp, 0.dp, 0.dp)
                  .size(40.dp)
                  .align(Alignment.Center) )

           Image(painter = painterResource(id = R.drawable.setting1)
               , contentDescription = null,
               modifier = Modifier
                   .clickable {
                       context.startActivity(Intent(context, popupSetting::class.java))
                   }
                   .padding(320.dp, 0.dp, 0.dp, 0.dp)
                   .size(40.dp)
                   .align(Alignment.Center) )
           

       }

        Spacer(modifier = Modifier.height(40.dp))

        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .height(160.dp)
            .background(colorResource(id = R.color.gray))
            ,horizontalAlignment = Alignment.CenterHorizontally) {

            Box(modifier = Modifier.fillMaxWidth()){
                
                Text(text = "Period : 1 fab - 28 fab", modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp), color = Color.White, fontSize = 15.sp)

                Image(painter = painterResource(id = R.drawable.more)
                    , contentDescription = null
                    , modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(10.dp)
                        .clickable {
                            context.startActivity(Intent(context, popupPeriod::class.java))
                        })
            }
            Spacer(modifier = Modifier.height(0.dp))

            Box(modifier = Modifier.fillMaxWidth()){

                Text(text = "$256000", modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(30.dp, 0.dp, 0.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 30.sp)

                Text(text = "$256000", modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(0.dp, 0.dp, 30.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 30.sp)
            }
            Spacer(modifier = Modifier.height(0.dp))

            Box(modifier = Modifier.fillMaxWidth()){

                Text(text = "Proceeds", modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(60.dp, 0.dp, 0.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 15.sp)

                Text(text = "Proceeds", modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(0.dp, 0.dp, 55.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(0.dp))

            Box(modifier = Modifier.fillMaxWidth()){

                Text(text = "0.0%", modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(80.dp, 0.dp, 0.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 15.sp)

                Text(text = "0.0%", modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(0.dp, 0.dp, 70.dp, 0.dp), color = colorResource(id = R.color.pink), fontSize = 15.sp)
            }
            Spacer(modifier = Modifier.height(0.dp))

            Box(modifier = Modifier.fillMaxWidth()){

                Text(text = "More...", modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(0.dp, 0.dp, 20.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 15.sp)
            }

        }
        Spacer(modifier = Modifier.height(0.dp))

        Box(modifier = Modifier.fillMaxWidth()){

            Text(text = "Order Per Week", modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp, 20.dp, 20.dp, 0.dp), color = colorResource(id = R.color.white), fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Column(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .width(360.dp)
            .fillMaxHeight()
            .padding(0.dp, 0.dp, 0.dp, 60.dp)
            .background(colorResource(id = R.color.gray))
            ,horizontalAlignment = Alignment.CenterHorizontally){

                val dataList = mutableListOf(4,0,0,0,0,0,0)
                val floatValue = mutableListOf<Float>()
                val datesList = mutableListOf("mon","tue","wed","thu","fri","sat","sun")

                dataList.forEachIndexed { index, value ->

                    floatValue.add(index = index, element = value.toFloat()/dataList.max().toFloat())

                }

                BarGraph(
                    graphBarData = floatValue,
                    xAxisScaleData = datesList,
                    barData_ = dataList,
                    height = 350.dp,
                    roundType = BarType.TOP_CURVED,
                    barWidth = 20.dp,
                    barColor = colorResource(id = R.color.pink),
                    barArrangement = Arrangement.SpaceEvenly
                )

        }
    }
}