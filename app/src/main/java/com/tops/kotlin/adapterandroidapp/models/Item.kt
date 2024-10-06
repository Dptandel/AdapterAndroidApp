package com.tops.kotlin.adapterandroidapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id: Int,
    val name: String,
    val quantity: Double,
    val unit: String,
    val price: Double,
    val image: Int
) : Parcelable
