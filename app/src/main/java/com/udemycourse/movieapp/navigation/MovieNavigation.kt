package com.udemycourse.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.udemycourse.movieapp.screens.details.DetailsScreen
import com.udemycourse.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.HomeScreen.name
    ) {
        composable(
            route = NavigationScreens.HomeScreen.name
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = NavigationScreens.DetailsScreen.name+"/{movieId}"
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getString("movieId")
            DetailsScreen(navController = navController, movieId = movieId.toString())
        }
    }

}