package com.tops.kotlin.adapterandroidapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tops.kotlin.adapterandroidapp.activitites.ItemDetailsActivity
import com.tops.kotlin.adapterandroidapp.databinding.RecyclerItemBinding
import com.tops.kotlin.adapterandroidapp.listeners.OnItemClickListener
import com.tops.kotlin.adapterandroidapp.models.Item

class ItemListAdapterNewOne(var context: Context, var itemList: MutableList<Item>) :
    Adapter<ItemListAdapterNewOne.MyViewHolder>() {

    private lateinit var itemListener: OnItemClickListener

    fun setOnItemClickListener(itemListener: OnItemClickListener) {
        this.itemListener = itemListener
    }

    inner class MyViewHolder(var binding: RecyclerItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemList[position]

        holder.binding.tvItemName.text = item.name
        holder.binding.tvItemQuantity.text = "${item.quantity} ${item.unit}"
        holder.binding.tvItemPrice.text = "$${item.price}"
        holder.binding.imgItem.setImageResource(item.image)

        holder.binding.recyclerItem.setOnClickListener {
            itemListener.onItemClicked(position, item)
        }

        holder.binding.tvItemName.setOnClickListener {
            itemListener.onItemTextClicked(position)
        }
    }
}