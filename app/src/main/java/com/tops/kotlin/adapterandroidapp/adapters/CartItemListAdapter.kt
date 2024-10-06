package com.tops.kotlin.adapterandroidapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tops.kotlin.adapterandroidapp.R
import com.tops.kotlin.adapterandroidapp.models.CartItem

class CartItemListAdapter(var context: Context, var cartItemList: MutableList<CartItem>) :
    Adapter<CartItemListAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val cartImgItem = itemView.findViewById<ImageView>(R.id.cartImgItem)
        val tvCartItemName = itemView.findViewById<TextView>(R.id.tvCartItemName)
        val tvCartItemQuantity = itemView.findViewById<TextView>(R.id.tvCartItemQuantity)
        val tvCartItemPrice = itemView.findViewById<TextView>(R.id.tvCartItemPrice)
        val tvItemCartQuantity = itemView.findViewById<TextView>(R.id.tvItemCartQuantity)
        val incCartItem = itemView.findViewById<ImageButton>(R.id.btnIncrement)
        val decCartItem = itemView.findViewById<ImageButton>(R.id.btnDecrement)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cart_recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartItemList.size
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cartItem = cartItemList[position]

        holder.tvCartItemName.text = cartItem.name
        holder.tvCartItemQuantity.text = "${cartItem.quantity} ${cartItem.unit}"
        holder.tvCartItemPrice.text = "$${cartItem.price}"
        holder.cartImgItem.setImageResource(cartItem.image)

        holder.decCartItem.setOnClickListener {
            if (cartItem.itemCount > 1) {
                cartItem.itemCount--
                holder.tvItemCartQuantity.text = cartItem.itemCount.toString()
                holder.tvCartItemPrice.text = "$${String.format("%.2f", cartItem.price * cartItem.itemCount)}"
            }
        }

        holder.incCartItem.setOnClickListener {
            cartItem.itemCount++
            holder.tvItemCartQuantity.text = cartItem.itemCount.toString()
            holder.tvCartItemPrice.text = "$${String.format("%.2f", cartItem.price * cartItem.itemCount)}"
        }
    }

}