package com.tops.kotlin.adapterandroidapp.activitites

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.tops.kotlin.adapterandroidapp.R
import com.tops.kotlin.adapterandroidapp.adapters.ItemListAdapterNewTwo
import com.tops.kotlin.adapterandroidapp.databinding.ActivityItemListBinding
import com.tops.kotlin.adapterandroidapp.listeners.OnItemClickListener
import com.tops.kotlin.adapterandroidapp.models.Item

class ItemListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemListBinding

    private lateinit var itemList: MutableList<Item>

    //    private lateinit var itemAdapter: ItemListAdapter
//    private lateinit var itemAdapter: ItemListAdapterNew
//    private lateinit var itemAdapter: ItemListAdapterNewOne
    private lateinit var itemAdapter: ItemListAdapterNewTwo

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

//        itemAdapter = ItemListAdapter(this, itemList)
//        itemAdapter = ItemListAdapterNew(this, itemList)
//        itemAdapter = ItemListAdapterNewOne(this, itemList)
        itemAdapter = ItemListAdapterNewTwo(this, itemList, { pos: Int, item: Item ->
            startActivity(Intent(applicationContext, ItemDetailsActivity::class.java).apply {
                putExtra("ITEM", item)
            })
        }, { pos: Int, title: String ->
            Toast.makeText(applicationContext, "$pos $title", Toast.LENGTH_SHORT).show()
        }, { pos: Int, item: Item ->
            val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
                .create()
            val view = layoutInflater.inflate(R.layout.item_dialog, null)
            view.findViewById<TextView>(R.id.tvDetails).text = """
                Item : ${pos + 1}
                Name : ${item.name}
                Price : $ ${item.price}
                Quantity : ${item.quantity.toInt()} ${item.unit}
            """.trimIndent()
            view.findViewById<ImageView>(R.id.ivImage).setImageResource(item.image)
            view.findViewById<TextView>(R.id.btnOk).setOnClickListener {
                builder.dismiss()
            }
            builder.setView(view)
            builder.setCanceledOnTouchOutside(false)
            builder.show()
        })

        // binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
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