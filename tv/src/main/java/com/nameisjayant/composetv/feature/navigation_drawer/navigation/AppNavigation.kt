package com.nameisjayant.composetv.feature.navigation_drawer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppNavigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = NavigationScreen.Home.route ){

        composable(NavigationScreen.Home.route){
            Text(text = "Home Screen")
        }
        composable(NavigationScreen.Movie.route){
            Text(text = "Movie Screen")
        }
        composable(NavigationScreen.Show.route){
            Text(text = "Show Screen")
        }
        composable(NavigationScreen.Wishlist.route){
            Text(text = "Wishlist Screen")
        }
        composable(NavigationScreen.Setting.route){
            Text(text = "Setting Screen")
        }

    }
}