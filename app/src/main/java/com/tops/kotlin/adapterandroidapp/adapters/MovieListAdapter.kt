package com.tops.kotlin.adapterandroidapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.tops.kotlin.adapterandroidapp.databinding.GridItemMovieBinding
import com.tops.kotlin.adapterandroidapp.models.Movie

class MovieListAdapter(var context: Context, var movieList: MutableList<Movie>): BaseAdapter() {

    private lateinit var binding: GridItemMovieBinding

    override fun getCount(): Int {
        return movieList.size
    }

    override fun getItem(position: Int): Any {
        return movieList[position]
    }

    override fun getItemId(position: Int): Long {
        return movieList[position].id.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        binding = GridItemMovieBinding.inflate(LayoutInflater.from(context), parent, false)

        val movie = movieList[position]
        binding.movieImg.setBackgroundResource(movie.movieImg)
        binding.movieName.text = movie.movieName
        binding.movieRating.text = movie.movieRating.toString()

        return binding.root
    }

}