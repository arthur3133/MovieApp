package com.udemycourse.movieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.udemycourse.movieapp.model.Movie

@Composable
fun MovieRow(
    movie: Movie,
    onClicked: (Movie) -> Unit
) {
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
            text = movie.title,
            style = MaterialTheme.typography.h6
        )
    }
    Divider()
}