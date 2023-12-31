package com.example.order_management_jetcompose

class Order {
    var price:String? =null
    var prepayment:String?=null
    var primecost:String?=null
    var description:String? =null
    var customer:String?=null
    var location:String?=null
    var date:String?=null
    var time:String?=null
    var uid:String?=null

    constructor(){}



    constructor(
        price: String?,
        prepayment: String?,
        primecost: String?,
        description: String?,
        location: String?,
        customer: String?,
        date: String?,
        time: String?,
        uid:String?
    ){
        this.price = price
        this.prepayment = prepayment
        this.primecost = primecost
        this.description = description
        this.customer = customer
        this.location = location
        this.date = date
        this.time = time
        this.uid = uid
    }
}