package com.tops.kotlin.adapterandroidapp.models

data class CartItem(
    val id: Int,
    val name: String,
    val quantity: Double,
    val unit: String,
    var itemCount: Int,
    val price: Double,
    val image: Int
)