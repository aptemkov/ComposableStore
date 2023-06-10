package com.github.aptemkov.onlinestore.app.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.aptemkov.onlinestore.app.AppNavHost
import com.github.aptemkov.onlinestore.app.LogInDestination
import com.github.aptemkov.onlinestore.app.MainPageDestination
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navController = rememberNavController()

            AppNavHost(navController = navController)

            //OnlineStoreApp()
            AuthState()
        }
    }


    @Composable
    private fun AuthState() {

        val isUserSignedOut = viewModel.getAuthState().collectAsState().value

        if (isUserSignedOut) {
            Log.i("TEST_AUTH", "is signed out")
            NavigateToSignInScreen()
        } else {
            Log.i("TEST_AUTH", "is signed in")
            if (viewModel.isEmailVerified) {
                NavigateToApp()
            } else {
                viewModel.sendEmailVerification()
                Toast.makeText(this, "Please, verify email", Toast.LENGTH_LONG).show()
                NavigateToApp()
                //MainScreen()
            }
        }
    }

    @Composable
    private fun NavigateToSignInScreen() = navController.navigate(LogInDestination.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToApp() = navController.navigate(MainPageDestination.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

}