package com.github.aptemkov.onlinestore.app.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.aptemkov.onlinestore.domain.models.Response
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme

@Composable
@Preview
fun LogInScreenPreview() {
    LogInScreen(
        onLogInClicked = {},
        onSignInClicked = {},
    )
}

@Composable
fun LogInScreen(
    onLogInClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {

    val response = viewModel.signInResponse
    LaunchedEffect(response) {
        if (response is Response.Failure) {
            Log.i("TEST_AUTH", "Log in failure: ${response.e.message}")
        }
    }

    var email by rememberSaveable() {
        mutableStateOf("")
    }
    var password by rememberSaveable() {
        mutableStateOf("")
    }

    OnlineStoreTheme {
        MaterialTheme {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xffF5F5F5))
                        .wrapContentSize(align = Alignment.Center)
                        .padding(all = 48.dp)

                ) {
                    HeadlineAuth(text = "Welcome back")
                    EditTextAuth(placeHolder = "Email", onValueChange =  { email = it; println("email $it") })
                    EditPasswordAuth(placeHolder = "Password", onValueChange =  { password = it; println("password $it") })
                    ButtonAuth(
                        text = "Log in",
                        onClick = {
                            onLogInClicked()
                            viewModel.signInWithEmailAndPassword(email, password)
                        }
                    )
                    HintUnderButtonAuth(
                        text1 = "Don't have an account?",
                        text2 = "Sign in",
                        onClick = onSignInClicked
                    )
                    SignInWithGoogleApple()
                }
            }

        }
    }
}