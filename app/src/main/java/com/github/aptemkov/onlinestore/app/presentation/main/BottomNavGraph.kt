package com.github.aptemkov.onlinestore.app.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomePageScreen()
        }
        composable(route = BottomBarScreen.Cart.route) {
            CartPageScreen()
        }
        composable(route = BottomBarScreen.Favourite.route) {
            FavouritePageScreen()
        }
        composable(route = BottomBarScreen.Chat.route) {
            ChatPageScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfilePageScreen()
        }
    }
}