package com.github.aptemkov.onlinestore.app.presentation.authorization

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.github.aptemkov.onlinestore.domain.models.Response.Failure
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme
import com.github.aptemkov.onlinestore.ui.theme.monserrat

@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen(
        onSignInClicked = {},
        onLogInClicked = {},
    )
}

@Composable
fun SignInScreen(
    onSignInClicked: () -> Unit,
    onLogInClicked: () -> Unit,
    viewModel: AuthorizationViewModel = hiltViewModel()
) {

    val response = viewModel.signUpResponse
    LaunchedEffect(response) {
        if (response is Failure) {
            Log.i("TEST_AUTH", "Register fail: ${response.e.message}")
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
                    HeadlineAuth(text = "Sign in")
                    EditTextAuth(placeHolder = "First name", onValueChange = { firstName = it })
                    EditTextAuth(placeHolder = "Email", onValueChange = { email = it })
                    EditPasswordAuth(placeHolder = "Password", onValueChange = { password = it })
                    ButtonAuth(text = "Sign in",
                        onClick = {
                            onSignInClicked()
                            viewModel.signUpWithEmailAndPassword(email, password)
                        })
                    HintUnderButtonAuth(
                        text1 = "Already have an account?",
                        text2 = "Log in",
                        onClick = onLogInClicked
                    )
                    SignInWithGoogleApple()
                }
            }
        }
    }
}

@Composable
fun SignInWithGoogleApple() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignInWith(
            modifier = Modifier.padding(bottom = 38.dp),
            text = "Sign in with Google",
            icon = R.drawable.ic_google,
            onClick = {}
        )
        SignInWith(
            text = "Sign in with Apple",
            icon = R.drawable.ic_apple,
            onClick = {}
        )
    }
}

@Composable
fun SignInWith(
    modifier: Modifier = Modifier,
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable { onClick() },

        ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier
                .size(24.dp),
        )
        Text(
            text = text,
            color = Color.Black,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = (-0.3).sp
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
        )
    }
}

@Composable
fun HintUnderButtonAuth(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = 15.dp, bottom = 70.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text1,
            color = Color(0xff808080),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
        )
        Text(
            text = text2,
            color = Color(0xff254fe6),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .padding(start = 8.dp)
                .clickable { onClick() }
        )
    }

}

@Composable
fun ButtonAuth(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults
            .buttonColors(
                containerColor = Color(0xff4e55d7),
                contentColor = Color(0xffEAEAEA),
            ),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 35.dp)
            .height(46.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = monserrat,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun HeadlineAuth(modifier: Modifier = Modifier, text: String) {

    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = text,
        style = TextStyle(
            fontFamily = monserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        ),

        )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun EditTextAuth(
    placeHolder: String = "",
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(15.dp)),
        value = text,
        onValueChange = { text = it; onValueChange(it) },
        placeholder = {
            Text(
                text = placeHolder,
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xff7b7b7b),
            containerColor = Color(0xffe8e8e8),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 35.dp)

    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)

fun EditPasswordAuth(
    placeHolder: String = "",
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }
    var visibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(15.dp)),
        value = text,
        onValueChange = { text = it; onValueChange(it) },
        placeholder = {
            Text(
                text = placeHolder,
                modifier = modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        trailingIcon = {
            Icon(
                painter = when (visibility) {
                    true -> painterResource(id = R.drawable.ic_lock)
                    false -> painterResource(id = R.drawable.ic_lock_open)
                },
                contentDescription = "",
                modifier = Modifier
                    .size(25.dp)
                    .clickable {
                        visibility = !visibility
                    },
            )
        },
        visualTransformation = if (visibility) VisualTransformation.None
        else PasswordVisualTransformation(),

        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xff7b7b7b),
            containerColor = Color(0xffe8e8e8),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 35.dp)

    )
}

@Composable
@Preview()
fun EditPasswordAuthPreview() {
    EditPasswordAuth(placeHolder = "Password", onValueChange = {})
}