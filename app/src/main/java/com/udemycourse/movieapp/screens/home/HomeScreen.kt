package com.udemycourse.movieapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.udemycourse.movieapp.model.Movie
import com.udemycourse.movieapp.model.getMovies
import com.udemycourse.movieapp.navigation.NavigationScreens
import com.udemycourse.movieapp.ui.theme.Purple700
import com.udemycourse.movieapp.ui.theme.topAppBarBackgroundColor
import com.udemycourse.movieapp.ui.theme.topAppBarTitleColor
import com.udemycourse.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = topAppBarBackgroundColor,
                elevation = AppBarDefaults.TopAppBarElevation
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Text(
                        text = "Movies",
                        style = MaterialTheme.typography.h6,
                        color = topAppBarTitleColor
                    )
                }

            }
        }
    ) {
        Content(navController = navController)
    }
}

@Composable
fun Content(
    navController: NavController,
    moviesList: List<Movie> = getMovies()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn {
            items(moviesList) { movie ->
                MovieRow(
                    movie = movie,
                    onClicked = {
                        navController.navigate(NavigationScreens.DetailsScreen.name+"/${movie.id}")
                    }
                )
            }
        }
    }
}