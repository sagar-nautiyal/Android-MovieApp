@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.businesscalling.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.businesscalling.movieapp.model.Movie
import com.businesscalling.movieapp.model.getMovies
import com.businesscalling.movieapp.navigation.MovieScreens
import com.businesscalling.movieapp.widget.MovieRow

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Movies")
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray))
    }){paddingValues ->
       MainContent(navController = navController, paddingValues = paddingValues)
    }
}


@Composable
fun MainContent(navController: NavController,
    paddingValues: PaddingValues, movieList: List<Movie> = getMovies()
){
    Column (modifier = Modifier
        .padding(paddingValues)
        .padding(12.dp)){

        LazyColumn {
            items(items = movieList){movie->
                MovieRow(movie = movie){selectedId->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$selectedId")
                }
            }
        }
    }
}
