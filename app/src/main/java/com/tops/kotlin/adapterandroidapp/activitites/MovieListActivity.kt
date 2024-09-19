package com.tops.kotlin.adapterandroidapp.activitites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tops.kotlin.adapterandroidapp.R
import com.tops.kotlin.adapterandroidapp.adapter.MovieListAdapter
import com.tops.kotlin.adapterandroidapp.databinding.ActivityMovieListBinding
import com.tops.kotlin.adapterandroidapp.model.Movie

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieListBinding

    private lateinit var movieList: MutableList<Movie>
    private lateinit var movieListAdapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // prepare data source
        prepareData()

        //gridView Languages
        movieListAdapter = MovieListAdapter(this, movieList)
        binding.gridViewLanguages.adapter = movieListAdapter
    }

    private fun prepareData() {
        movieList = mutableListOf<Movie>().apply {
            add(Movie(1, R.drawable.movie_1, "Dune (Part II)", 8.5f))
            add(Movie(2, R.drawable.movie_2, "Furiosa: A Mad Max Saga", 7.5f))
            add(Movie(1, R.drawable.movie_3, "Inside Out 2", 7.7f))
            add(Movie(2, R.drawable.movie_4, "Ghostlight", 7.5f))
            add(Movie(1, R.drawable.movie_5, "Young Woman and the Sea", 7.6f))
            add(Movie(2, R.drawable.movie_6, "Challengers", 7.2f))
            add(Movie(1, R.drawable.movie_7, "Deadpool & Wolverine", 8.0f))
            add(Movie(2, R.drawable.movie_8, "Beetlejuice Beetlejuice", 7.1f))
            add(Movie(1, R.drawable.movie_9, "Good One", 7.2f))
        }
    }
}