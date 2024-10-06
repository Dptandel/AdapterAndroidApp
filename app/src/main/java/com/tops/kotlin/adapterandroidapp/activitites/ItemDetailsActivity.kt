package com.tops.kotlin.adapterandroidapp.activitites

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.adapterandroidapp.databinding.ActivityItemDetailsBinding
import com.tops.kotlin.adapterandroidapp.models.Item

class ItemDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemDetailsBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("ITEM", Item::class.java)
        } else {
            intent.getParcelableExtra("ITEM")
        }

        item?.let {
            binding.tvDetails.text = """
                Name : ${item.name}
                Price : ${item.price}
                Quantity : ${item.quantity.toInt()} ${item.unit}
            """.trimIndent()

            binding.imgItem.setImageResource(item.image)
        }
    }
}