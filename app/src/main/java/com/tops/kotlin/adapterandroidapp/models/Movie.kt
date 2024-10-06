package com.tops.kotlin.adapterandroidapp.models

data class Movie(
    val id:Int,
    val movieImg: Int,
    val movieName: String,
    val movieRating: Float = 0.0f
)
