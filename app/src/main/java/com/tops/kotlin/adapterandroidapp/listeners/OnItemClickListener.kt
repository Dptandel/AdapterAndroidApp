package com.tops.kotlin.adapterandroidapp.listeners

import com.tops.kotlin.adapterandroidapp.models.Item

interface OnItemClickListener {
    fun onItemClicked(pos: Int, item: Item)
    fun onItemTextClicked(pos: Int)
}