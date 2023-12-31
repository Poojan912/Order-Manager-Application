package com.example.order_management_jetcompose.Composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.order_management_jetcompose.BottomBarScreen
import com.example.order_management_jetcompose.CheckList1
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

@Composable
fun BottomNavGraph(navController: NavHostController,padding: PaddingValues){
    var orderId : Int? = null
    var uid = FirebaseAuth.getInstance().currentUser?.uid
    var mdref : DatabaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(uid.toString()).child("order")
    mdref.addValueEventListener(object  : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            orderId = snapshot.childrenCount.toInt()
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }

    })
    NavHost(
        navController = navController,
        startDestination = "setting",
        builder = {
            composable("checklist") {
                if(orderId == 0){
                    CheckList()
                }else{
                    CheckList1()
                }

            }
            composable("trend") {
                Trend()
            }
            composable("setting") {
                Setting()
            }
        })
}