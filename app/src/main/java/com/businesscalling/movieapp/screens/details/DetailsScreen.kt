@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.businesscalling.movieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.businesscalling.movieapp.model.Movie
import com.businesscalling.movieapp.model.getMovies
import com.businesscalling.movieapp.widget.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DetailsScreen(navController: NavController,
                  movieId: String?){
    val newMovieList = getMovies().filter {movie ->
        movie.id == movieId

    }


    Scaffold(topBar = {
        TopAppBar({
            Row {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Arrow back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))

                Text(text = "Movies")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray))
    }) {paddingValues->
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(paddingValues)) {
            Column(verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start) {
                MovieRow(movie = newMovieList.first())

                Text(text = "Images", modifier = Modifier.padding(10.dp),  style = MaterialTheme.typography.headlineMedium, textAlign = TextAlign.Start)

                Spacer(modifier = Modifier.height(10.dp))
                Divider()
                HorizontalScrollableMovieRow(newMovieList)

            }

        }
    }








}

@Composable
private fun HorizontalScrollableMovieRow(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .size(200.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {


                Image(
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "Movie Image",
                    modifier = Modifier.fillMaxSize()
                )

            }

        }


    }
}