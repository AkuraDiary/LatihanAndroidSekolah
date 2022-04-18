package com.smktelkommlg.movieproject

import retrofit2.Call
import retrofit2.http.GET


interface MovieService {
    @GET("/JSONParsingTutorial/jsonMovie")
    fun getMovies(): Call<MovieService?>?
}