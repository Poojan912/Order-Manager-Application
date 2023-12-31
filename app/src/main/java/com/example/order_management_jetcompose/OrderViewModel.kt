package com.example.order_management_jetcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class OrderViewModel : ViewModel() {

    var orderlist:ArrayList<Order> = arrayListOf()

    var uid= FirebaseAuth.getInstance().currentUser?.uid

    var mdref : DatabaseReference = FirebaseDatabase.getInstance().getReference().child("User").child(uid.toString()).child("order")
   init {
       mdref.addValueEventListener(object : ValueEventListener {
           override fun onDataChange(dataSnapshot: DataSnapshot) {
               orderlist.clear()
               val map = dataSnapshot.getValue() as HashMap<*, *>
               map.entries.forEach {
                   val data = it.value as HashMap<*, *>
                   val customer = data["customer"].toString()
                   val price = data["price"].toString()
                   val prepayment = data["prepayment"].toString()
                   val primecost = data["primecost"].toString()
                   val des = data["description"].toString()
                   val loc = data["location"].toString()
                   val date = data["date"].toString()
                   val time = data["time"].toString()

                   val order = Order(price, prepayment, primecost, des, customer, loc, date, time, uid)
                   orderlist.add(order)

               }

           }

           override fun onCancelled(databaseError: DatabaseError) {

           }
       })
   }

}