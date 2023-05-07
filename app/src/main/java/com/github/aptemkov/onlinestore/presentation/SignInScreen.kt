package com.github.aptemkov.onlinestore.presentation

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme
import com.github.aptemkov.onlinestore.ui.theme.monserrat


@Composable
@Preview(showBackground = true)
fun SignInScreen() {
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
                    EditTextAuth(placeHolder = "First name")
                    EditTextAuth(placeHolder = "Last name")
                    EditTextAuth(placeHolder = "Email")
                    ButtonAuth()
                    HintUnderButtonAuth(onClick = {})
                    SignInWithGoogle()
                }
            }

        }
    }
}

@Composable
fun SignInWithGoogle() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Authorization with Google",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "Sign in with Google",
            color = Color.Black,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = -0.3.sp),
            modifier = Modifier
                .width(width = 117.dp)
                .height(height = 16.dp)
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
        )
    }
}

@Composable
fun HintUnderButtonAuth(modifier: Modifier = Modifier, onClick : () -> Unit) {
    Row(
        modifier = modifier.padding(top = 15.dp),
    ) {
        Text(
            text = "Already have an account?",
            color = Color(0xff808080),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
        )
        Text(
            text = "Log in",
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
fun ButtonAuth(modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults
            .buttonColors(
                containerColor = Color(0xff4e55d7),
                contentColor = Color(0xffEAEAEA),

                ),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
            .height(46.dp)
    ) {
        Text(
            text = "Sign In",
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
        text = "Sign in",
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
@Preview()
fun EditTextAuth(placeHolder: String = "", modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(placeHolder) },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        colors = TextFieldDefaults.textFieldColors(
            //textColor = Color(0xff7b7b7b),
            containerColor = Color(0xffe8e8e8)
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 35.dp)

    )
}
