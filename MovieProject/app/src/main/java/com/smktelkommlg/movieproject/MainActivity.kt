package com.smktelkommlg.movieproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    var rvMovie : RecyclerView? = null
    var movieAdapter : MovieAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listMovie = ArrayList<SearchItem>()
        rvMovie = findViewById(R.id.list_movies)

        movieAdapter = MovieAdapter(listMovie)

        rvMovie?.apply {
            adapter = movieAdapter
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this@MainActivity)
            /*addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoratxion.VERTICAL
                )
            )*/
        }


        RestClient.getMovieService().getMovies().enqueue(
            object : Callback<MovieService> {
                override fun onResponse(
                    call: Call<MovieService>,
                    response: Response<MovieService>
                ) {
                    if (response.isSuccessful) {
                        val movieResponse = response.body()
                        if (movieResponse != null) {
                            val listItems = movieResponse.getMovies()
                            movieAdapter?.setData(listItems)
                        }
                    }
                }

                override fun onFailure(call: Call<MovieService>, t: Throwable) {
                    // Log error here since request failed
                    Log.e("MainActivity", t.toString())
                }
            })
    }
}