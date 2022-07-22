package com.udemycourse.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udemycourse.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                HomeScreen()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary,
                elevation = AppBarDefaults.TopAppBarElevation
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Text(
                        text = "Movies",
                        style = MaterialTheme.typography.h6
                    )
                }

            }
        }
    ) {
        Content()
    }
}

@Composable
fun Content(
    moviesList: List<String>
    = listOf(
        "Avenger: End Game",
        "Thor",
        "Black Widow",
        "Doctor Strange",
        "Spider Man",
        "Avatar",
        "Superman",
        "Justice League",
        "Batman",
        "Game Of Throne",
        "13 Reason Why",
        "Stranger Things",
        "Sex Education"
    )
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn {
            items(moviesList) { movieName ->
                MovieRow(
                    movieName = movieName,
                    onClicked = {

                    }
                )
            }
        }
    }
}

@Composable
fun MovieRow(
    movieName: String,
    onClicked: (String) -> Unit
) {
   Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(10.dp)
           .background(MaterialTheme.colors.background)
           .clickable {
               onClicked(movieName)
           },
       horizontalArrangement = Arrangement.Start,
       verticalAlignment = Alignment.CenterVertically
   ) {
       Card(
           modifier = Modifier
               .size(120.dp)
               .padding(10.dp),
           elevation = 4.dp,
           shape = RoundedCornerShape(4.dp)
       ) {
           Image(
               imageVector = Icons.Default.AccountBox,
               contentDescription = "Movie Image"
           )
       }
       Spacer(modifier = Modifier.width(20.dp))
       Text(
           text = movieName,
           style = MaterialTheme.typography.h6
       )
   }
    Divider()
}