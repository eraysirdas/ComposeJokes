package com.eraysirdas.jokes.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eraysirdas.jokes.service.client.RetrofitClient
import com.eraysirdas.jokes.model.Joke
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JokeViewModel  : ViewModel(){

    val jokes = mutableStateOf<List<Joke>>(listOf())

    fun getJokes(){
        viewModelScope.launch(Dispatchers.IO) {
            jokes.value = RetrofitClient.jokeService.getJokes()
        }
    }
}