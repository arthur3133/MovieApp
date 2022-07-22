package com.udemycourse.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.udemycourse.movieapp.model.getMovies
import com.udemycourse.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.background,
                elevation = AppBarDefaults.TopAppBarElevation
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, 
                        contentDescription = "Arrow Back Icon",
                        tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                    })
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Movie Details",
                        style = MaterialTheme.typography.h6,
                        color = if (isSystemInDarkTheme()) Color.White else Color.Black
                    )
                }
            }
        }
    ) {
        Content(movieId = movieId)
    }
}

@Composable
fun Content(movieId: String) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(3.dp)
        ) {
            MovieRow(movie = newMovieList[0])
            Text(
                text = "Movie Images",
                style = MaterialTheme.typography.h5
            )
            LazyRow {
                items(newMovieList.first().images) { image ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image)
                            .crossfade(true)
                            .build(),
                        contentDescription = "Movie Images",
                        modifier = Modifier
                            .padding(4.dp)
                            .width(150.dp)
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}