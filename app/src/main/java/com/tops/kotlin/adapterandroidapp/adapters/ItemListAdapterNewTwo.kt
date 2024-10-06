package com.tops.kotlin.adapterandroidapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tops.kotlin.adapterandroidapp.databinding.RecyclerItemBinding
import com.tops.kotlin.adapterandroidapp.listeners.OnItemClickListener
import com.tops.kotlin.adapterandroidapp.models.Item

class ItemListAdapterNewTwo(
    var context: Context,
    var itemList: MutableList<Item>,
    var itemClicked: ((pos: Int, item: Item) -> Unit)? = null,
    var textClicked: ((pos: Int, title: String) -> Unit)? = null,
    var viewDetailsClicked: ((pos: Int, item: Item) -> Unit)? = null
) :
    Adapter<ItemListAdapterNewTwo.MyViewHolder>() {

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
            itemClicked?.invoke(position, item)
        }

        holder.binding.tvItemName.setOnClickListener {
            textClicked?.invoke(position, item.name)
        }

        holder.binding.imgViewDetails.setOnClickListener {
            viewDetailsClicked?.invoke(position, item)
        }
    }
}