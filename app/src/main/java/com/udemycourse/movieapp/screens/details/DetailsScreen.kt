package com.udemycourse.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.udemycourse.movieapp.ui.theme.topAppBarBackgroundColor
import com.udemycourse.movieapp.ui.theme.topAppBarTitleColor

@Composable
fun DetailsScreen(navController: NavController, movieId: String) {
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
                    Icon(
                        imageVector = Icons.Default.ArrowBack, 
                        contentDescription = "Arrow Back Icon",
                        tint = topAppBarTitleColor,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                    })
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Movie Details",
                        style = MaterialTheme.typography.h6,
                        color = topAppBarTitleColor
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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Text(text = movieId)
    }
}