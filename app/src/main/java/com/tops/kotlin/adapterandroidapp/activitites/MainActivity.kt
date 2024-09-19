package com.tops.kotlin.adapterandroidapp.activitites

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.adapterandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var languages = arrayOf("Java", "Kotlin", "Dart", "PHP", "C#", "C++", "C", "JavaScript", "HTML", "CSS", "Ruby", "Python")

    private lateinit var listAdapter : ArrayAdapter<String>
    private lateinit var gridAdapter : ArrayAdapter<String>
    private lateinit var spinnerAdapter : ArrayAdapter<String>
    private lateinit var actvAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        gridAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        actvAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)

        binding.listView.adapter = listAdapter
        binding.gridView.adapter = gridAdapter
        binding.spinnerView.adapter = spinnerAdapter
        binding.autoCompleteTV.setAdapter(actvAdapter)
        binding.autoCompleteTV.threshold = 1

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            var language = languages[position]
            Toast.makeText(this, language, Toast.LENGTH_SHORT).show()
        }

        binding.gridView.setOnItemClickListener { parent, view, position, id ->
            var language = languages[position]
            Toast.makeText(this, language, Toast.LENGTH_SHORT).show()
        }

        binding.btnShowPersons.setOnClickListener {
            startActivity(Intent(this, CustomListActivity::class.java))
        }

        binding.btnShowMovies.setOnClickListener {
            startActivity(Intent(this, MovieListActivity::class.java))
        }

        binding.btnShowCartItems.setOnClickListener {
            startActivity(Intent(this, ItemListActivity::class.java))
        }
    }
}