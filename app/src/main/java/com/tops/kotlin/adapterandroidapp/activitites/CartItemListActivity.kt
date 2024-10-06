package com.tops.kotlin.adapterandroidapp.activitites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.tops.kotlin.adapterandroidapp.R
import com.tops.kotlin.adapterandroidapp.adapters.CartItemListAdapter
import com.tops.kotlin.adapterandroidapp.databinding.ActivityItemListBinding
import com.tops.kotlin.adapterandroidapp.models.CartItem

class CartItemListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemListBinding

    private lateinit var cartItemList: MutableList<CartItem>
    private lateinit var cartItemAdapter: CartItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        cartItemAdapter = CartItemListAdapter(this, cartItemList)

        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.recyclerView.adapter = cartItemAdapter
    }

    private fun prepareData() {
        cartItemList = mutableListOf<CartItem>().apply {
            add(CartItem(1, "Bell Pepper Red", 1.0, "kg", 1, 4.99, R.drawable.cart_item_1))
            add(CartItem(2, "Egg Chicken Red", 4.0, "pcs", 1, 1.99, R.drawable.cart_item_2))
            add(CartItem(3, "Organic Bananas", 12.0, "kg", 1, 2.99, R.drawable.cart_item_3))
            add(CartItem(4, "Ginger", 250.0, "gram", 1, 2.99, R.drawable.cart_item_4))
        }
    }
}