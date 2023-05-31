package com.example.imdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IMDbApi {

    @GET("/en/API/SearchMovie/k_obo30xzp/{expression}")
    fun findMovie(@Path("expression")  expression:String): Call<MoviesResponse>
}