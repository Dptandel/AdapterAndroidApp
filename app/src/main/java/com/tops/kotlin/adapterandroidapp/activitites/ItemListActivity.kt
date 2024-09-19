package com.tops.kotlin.adapterandroidapp.activitites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.adapterandroidapp.R
import com.tops.kotlin.adapterandroidapp.adapter.ItemListAdapter
import com.tops.kotlin.adapterandroidapp.databinding.ActivityItemListBinding
import com.tops.kotlin.adapterandroidapp.model.Item

class ItemListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemListBinding

    private lateinit var itemList: MutableList<Item>
    private lateinit var itemAdapter: ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        itemAdapter = ItemListAdapter(this, itemList)

        // binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = itemAdapter
    }

    private fun prepareData() {
        itemList = mutableListOf<Item>().apply {
            add(Item(1, "Sprite Can", 325.0, "ml", 1.50, R.drawable.image_1))
            add(Item(2, "Diet Coke", 355.0, "ml", 1.99, R.drawable.image_2))
            add(Item(3, "Apple & Grape Juice", 2.0, "l", 15.50, R.drawable.image_3))
            add(Item(4, "Coca Cola Can", 325.0, "ml", 4.99, R.drawable.image_4))
            add(Item(5, "Pepsi Can", 330.0, "ml", 4.99, R.drawable.image_5))
        }
    }
}