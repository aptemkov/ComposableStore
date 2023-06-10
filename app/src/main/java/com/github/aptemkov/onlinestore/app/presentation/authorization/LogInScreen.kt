package com.github.aptemkov.onlinestore.app.presentation.authorization

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.aptemkov.onlinestore.app.TEST_AUTH
import com.github.aptemkov.onlinestore.domain.models.Response.Failure
import com.github.aptemkov.onlinestore.domain.models.Response.Success
import kotlinx.coroutines.launch

@Composable
@Preview
fun LogInScreenPreview() {
    LogInScreen(
        onLogInClicked = {},
        onSignInClicked = {},
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LogInScreen(
    onLogInClicked: () -> Unit,
    onSignInClicked: () -> Unit,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    var isError = false
    var errorMessage: String? = null

    val response = viewModel.signInResponse
    LaunchedEffect(response) {
        if (response is Failure) {
            Log.i(TEST_AUTH, "Log in failure: ${response.e.message}")
            isError = true
            errorMessage = response.e.message
        } else {
            isError = false
            errorMessage = null
        }
    }

    var email by rememberSaveable() {
        mutableStateOf("")
    }
    var password by rememberSaveable() {
        mutableStateOf("")
    }
    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xffF5F5F5))
                .wrapContentSize(align = Alignment.Center)
                .padding(all = 48.dp)

        ) {
            HeadlineAuth(text = "Welcome back")
            EditTextAuth(placeHolder = "Email", onValueChange = { email = it.trim() })
            EditPasswordAuth(placeHolder = "Password", onValueChange = { password = it })
            ButtonAuth(
                text = "Log in",
                onClick = {
                    viewModel.signInWithEmailAndPassword(email, password)
                    onLogInClicked()

                    coroutineScope.launch {
                        if(isError)
                            errorMessage?.let { message ->
                                scaffoldState.snackbarHostState.showSnackbar(message)
                            }
                        /*
                        if(!viewModel.isEmailVerified) {
                            viewModel.sendEmailVerification()
                            scaffoldState.snackbarHostState.showSnackbar("Please, verify email")
                        }
                        */
                    }

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