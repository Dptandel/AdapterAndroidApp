package com.tops.kotlin.adapterandroidapp.activitites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.adapterandroidapp.R
import com.tops.kotlin.adapterandroidapp.adapters.PersonListAdapter
import com.tops.kotlin.adapterandroidapp.databinding.ActivityCustomListBinding
import com.tops.kotlin.adapterandroidapp.models.Person

class CustomListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCustomListBinding

    private lateinit var personList: MutableList<Person>
    private lateinit var personListAdapter: PersonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // prepare data source
        prepareData()

        personListAdapter = PersonListAdapter(this, personList)
        binding.listViewPerson.adapter = personListAdapter
    }

    private fun prepareData() {
        personList = mutableListOf<Person>().apply {
            add(Person(1, R.drawable.a, "Christopher", "Heye", "8:45 pm"))
            add(Person(2, R.drawable.b, "Craig", "Supp", "9:00 am"))
            add(Person(3, R.drawable.c, "Sergio", "Let's Catchup", "7:34 pm"))
            add(Person(4, R.drawable.d, "Mubariz", "Dinner tonight?", "6:32 am"))
            add(Person(5, R.drawable.e, "Mike", "Gotta go", "5:06 am"))
            add(Person(6, R.drawable.f, "Evana", "I'm in meeting", "5:00 am"))
            add(Person(7, R.drawable.g, "Toa", "Gotcha", "7:34 pm"))
            add(Person(8, R.drawable.h, "Michael", "Let's go", "2:32 am"))
            add(Person(9, R.drawable.i, "Alex", "Any weekend plans?", "7:45 am"))
        }
    }
}