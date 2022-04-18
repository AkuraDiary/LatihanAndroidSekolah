package com.smktelkommlg.movieproject

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {
    fun getMovieService(): MovieService {
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/?s=batman&apikey=2268147d")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(MovieService::class.java)
    }
}