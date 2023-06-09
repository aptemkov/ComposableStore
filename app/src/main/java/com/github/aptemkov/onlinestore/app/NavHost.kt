package com.github.aptemkov.onlinestore.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.aptemkov.onlinestore.app.presentation.authorization.LogInScreen
import com.github.aptemkov.onlinestore.app.presentation.authorization.SignInScreen
import com.github.aptemkov.onlinestore.app.presentation.main.MainScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "log_in",
        modifier = modifier
    ) {
        composable(route = LogInDestination.route) {
            LogInScreen(
                onLogInClicked = { println("Log in pressed") },
                onSignInClicked = { navController.navigateSingleTopTo(SignInDestination.route) }
            )
        }
        composable(route = SignInDestination.route) {
            SignInScreen(
                onSignInClicked = { println("Sign in pressed") },
                onLogInClicked = { navController.navigateSingleTopTo(LogInDestination.route) }
            )
        }

        composable(route = MainPageDestination.route) {
            MainScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }