package com.eraysirdas.jokes.service

import com.eraysirdas.jokes.model.Joke
import retrofit2.http.GET

interface JokeService {

    @GET("atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json")
    suspend fun getJokes() : List<Joke>
}