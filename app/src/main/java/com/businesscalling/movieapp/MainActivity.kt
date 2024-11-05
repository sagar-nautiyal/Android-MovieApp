package com.businesscalling.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.businesscalling.movieapp.navigation.MovieNavigation
import com.businesscalling.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp{
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () ->Unit){
    MovieAppTheme {
        content()
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovieAppTheme {
        MyApp{
            MovieNavigation()
        }
    }
}