package com.udemycourse.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.udemycourse.movieapp.model.Movie

@Composable
fun MovieRow(
    movie: Movie,
    onClicked: (Movie) -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(MaterialTheme.colors.background)
            .clickable {
                onClicked(movie)
            },
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp),
            elevation = 4.dp,
            shape = CircleShape
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie.images[0])
                    .crossfade(true)
                    .build(),
                contentDescription = "Movie Image",
                contentScale = ContentScale.Crop
            )
        }
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Director: ${movie.director}",
                style = MaterialTheme.typography.caption
            )
            Text(
                text = "Released: ${movie.year}",
                style = MaterialTheme.typography.caption
            )
            AnimatedVisibility(visible = expanded) {
                Column {
                    Text( buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            fontSize = 13.sp
                        )) {
                            append("Plot: ")
                        }
                        withStyle(style = SpanStyle(
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )) {
                            append(movie.plot)
                        }
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Actors: ${movie.actors}",
                        style = MaterialTheme.typography.caption
                    )
                    Text(
                        text = "Rating: ${movie.rating}",
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = "Arrow Drop Down Or Up Icon",
                tint = Color.DarkGray,
                modifier = Modifier
                    .clickable {
                        expanded = !expanded
                    }
                    .size(25.dp)
            )
        }
    }
    Divider()
}