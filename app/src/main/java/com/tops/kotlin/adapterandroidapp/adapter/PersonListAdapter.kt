package com.tops.kotlin.adapterandroidapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.tops.kotlin.adapterandroidapp.databinding.ListItemPersonBinding
import com.tops.kotlin.adapterandroidapp.model.Person

class PersonListAdapter(var context: Context, var personList: MutableList<Person>): BaseAdapter() {

    private lateinit var binding: ListItemPersonBinding

    override fun getCount(): Int {
        return personList.size
    }

    override fun getItem(position: Int): Any {
        return personList[position]
    }

    override fun getItemId(position: Int): Long {
        return personList[position].id.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = ListItemPersonBinding.inflate(LayoutInflater.from(context), parent, false)

        var person = personList[position]
        binding.tvPersonName.text = person.personName
        binding.tvLastMessage.text = person.lastMessage
        binding.tvTime.text = person.msgTime
        binding.profilePic.setImageResource(person.profileImg)

        return binding.root
    }

}