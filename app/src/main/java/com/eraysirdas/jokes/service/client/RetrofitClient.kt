package com.eraysirdas.jokes.service.client

import com.eraysirdas.jokes.service.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://raw.githubusercontent.com/"

    val jokeService : JokeService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeService::class.java)
    }
}