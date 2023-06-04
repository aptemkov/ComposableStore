package com.github.aptemkov.onlinestore.app.presentation.main.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.github.aptemkov.onlinestore.app.presentation.main.cart.CartPageScreen
import com.github.aptemkov.onlinestore.app.presentation.main.chat.ChatPageScreen
import com.github.aptemkov.onlinestore.app.presentation.main.favourite.FavouritePageScreen
import com.github.aptemkov.onlinestore.app.presentation.main.home.HomePageScreen
import com.github.aptemkov.onlinestore.app.presentation.main.profile.ProfilePageScreen

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