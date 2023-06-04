package com.github.aptemkov.onlinestore.app.presentation.authorization

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.aptemkov.onlinestore.R
import com.github.aptemkov.onlinestore.app.TEST_AUTH
import com.github.aptemkov.onlinestore.domain.models.Response.Failure
import com.github.aptemkov.onlinestore.ui.theme.monserrat
import kotlinx.coroutines.launch

@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen(
        onSignInClicked = {},
        onLogInClicked = {},
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    onSignInClicked: () -> Unit,
    onLogInClicked: () -> Unit,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {

    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    var isError = false
    var errorMessage: String? = null

    val response = viewModel.signUpResponse
    LaunchedEffect(response) {
        if (response is Failure) {
            Log.i(TEST_AUTH, "Register failure: ${response.e.message}")
            isError = true
            errorMessage = response.e.message
        } else {
            isError = false
            errorMessage = null
        }
    }

    var firstName by rememberSaveable() {
        mutableStateOf("")
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
            HeadlineAuth(text = "Sign in")
            EditTextAuth(placeHolder = "First name", onValueChange = { firstName = it })
            EditTextAuth(placeHolder = "Email", onValueChange = { email = it })
            EditPasswordAuth(placeHolder = "Password", onValueChange = { password = it })
            ButtonAuth(text = "Sign in", onClick = {
                onSignInClicked()
                viewModel.signUpWithEmailAndPassword(email, password)

                coroutineScope.launch {
                    if (isError) errorMessage?.let { message ->
                        scaffoldState.snackbarHostState.showSnackbar(message)
                    }
                }


            })
            HintUnderButtonAuth(
                text1 = "Already have an account?", text2 = "Log in", onClick = onLogInClicked
            )
            SignInWithGoogleApple()
        }
    }
}

@Composable
fun SignInWithGoogleApple() {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignInWith(modifier = Modifier.padding(bottom = 38.dp),
            text = "Sign in with Google",
            icon = R.drawable.ic_google,
            onClick = {})
        SignInWith(text = "Sign in with Apple", icon = R.drawable.ic_apple, onClick = {})
    }
}

@Composable
fun SignInWith(
    modifier: Modifier = Modifier, text: String, @DrawableRes icon: Int, onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable { onClick() },

        ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = text, color = Color.Black, style = TextStyle(
                fontSize = 12.sp, fontWeight = FontWeight.Medium, letterSpacing = (-0.3).sp
            ), modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
        )
    }
}


@Composable
@Preview()
fun EditPasswordAuthPreview() {
    EditPasswordAuth(placeHolder = "Password", onValueChange = {})
}