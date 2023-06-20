package com.github.aptemkov.onlinestore.app.presentation.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R
import com.github.aptemkov.onlinestore.app.presentation.authorization.ButtonAuth
import com.github.aptemkov.onlinestore.app.presentation.main.DefaultTopAppBar
import com.github.aptemkov.onlinestore.data.repository.AuthorizationRepositoryImpl
import com.google.firebase.auth.FirebaseAuth

@Preview
@Composable
fun ProfilePageScreenPreview() {
    ProfilePageScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePageScreen() {
    val repo = AuthorizationRepositoryImpl(FirebaseAuth.getInstance())

    Scaffold(
        topBar = {
            DefaultTopAppBar(
                showStartIcon = false,
                startIcon = painterResource(id = R.drawable.arrow_back),
                label = "Profile",
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .background(color = Color(0xffFAF9FF))
                .fillMaxSize()
                .padding(start = 32.dp, end = 32.dp, top = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            item(1) {
                ProfilePhoto(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    modifier = Modifier.padding(top = 16.dp)
                )


                Text(
                    text = "Change photo",
                    color = Color(0xff808080),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = (-0.3).sp
                    ),
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 17.dp)
                )

                Text(
                    text = "Artyom K.",
                    color = Color(0xff3f3f3f),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = (-0.3).sp
                    ),
                    modifier = Modifier
                )

                ButtonAuth(
                    text = "Upload item",
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {}

                ProfileButton(
                    icon = painterResource(id = R.drawable.ic_credit_card),
                    label = "Trade store",
                    onClick = { },
                    showEndArrow = true,
                    showEndLabel = false
                )
                ProfileButton(
                    icon = painterResource(id = R.drawable.ic_credit_card),
                    label = "Payment method",
                    onClick = { },
                    showEndArrow = true,
                    showEndLabel = false
                )
                ProfileButton(
                    icon = painterResource(id = R.drawable.ic_credit_card),
                    label = "Balance",
                    onClick = { },
                    showEndArrow = false,
                    showEndLabel = true,
                    endLabel = "$1593"
                )
                ProfileButton(
                    icon = painterResource(id = R.drawable.ic_credit_card),
                    label = "Trade history",
                    onClick = { },
                    showEndArrow = true,
                    showEndLabel = false
                )
                ProfileButton(
                    icon = painterResource(id = R.drawable.ic_refresh),
                    label = "Restore Purchase",
                    onClick = { },
                    showEndArrow = true,
                    showEndLabel = false
                )
                ProfileButton(
                    icon = painterResource(id = R.drawable.ic_help),
                    label = "Help",
                    onClick = { },
                    showEndArrow = false,
                    showEndLabel = false
                )
                ProfileButton(
                    icon = painterResource(id = R.drawable.baseline_logout_24),
                    label = "Logout",
                    onClick = { repo.signOut() },
                    showEndArrow = false,
                    showEndLabel = false
                )
            }
        }
    }
}