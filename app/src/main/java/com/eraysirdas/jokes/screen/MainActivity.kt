package com.eraysirdas.jokes.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eraysirdas.jokes.viewmodel.JokeViewModel
import com.eraysirdas.jokes.model.Category
import com.eraysirdas.jokes.model.Flags
import com.eraysirdas.jokes.model.Joke
import com.eraysirdas.jokes.model.Lang
import com.eraysirdas.jokes.model.Type
import com.eraysirdas.jokes.ui.theme.JokesTheme

class MainActivity : ComponentActivity() {
    private val viewModel : JokeViewModel by viewModels<JokeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){

                        viewModel.getJokes()
                        JokeList(viewModel.jokes.value)

                    }
                }
            }
        }
    }
}



@Composable
fun JokeList(jokeList : List<Joke>){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        items(jokeList){joke->
            JokeRow(joke = joke)
        }
    }

}

@Composable
fun JokeRow(joke : Joke){
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .border(BorderStroke(2.dp, Color.Black))
            .padding(10.dp)
    ) {
        if(joke.type == "twopart"){

            Text(text = ("+ " + joke.setup) ?: "",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.SemiBold)

            Text(text = ("- " + joke.delivery) ?: "",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.SemiBold)


        }else{

            Text(text = joke.joke ?: "",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.SemiBold)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JokeRow(
        Joke(false, Category.Programming, Type.twopart.toString(),"seni cem sordu","sivilcem",
        Flags(false,false,false,false,false,false),15,false, Lang.En
    )
    )
}