package com.github.aptemkov.onlinestore.app.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R
import com.github.aptemkov.onlinestore.app.presentation.authorization.ButtonAuth
import com.github.aptemkov.onlinestore.data.AuthorizationRepositoryImpl
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme
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
    OnlineStoreTheme {
        MaterialTheme {
            Scaffold(
                modifier = Modifier.background(color = Color(0xffFAF9FF)),
                topBar = {
                    DefaultTopAppBar(
                        showStartIcon = true,
                        startIcon = painterResource(id = R.drawable.arrow_back),
                        label = "Profile"
                    )
                }
            ) { padding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {

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
                        text = "Satria Adhi Pradana",
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
}


@Composable
fun ProfilePhoto(
    modifier: Modifier = Modifier,
    painter: Painter,
) {

    Image(
        painter = painter,
        contentDescription = "Profile icon",
        modifier = modifier
            .size(64.dp)
            .clip(shape = RoundedCornerShape(25.dp))
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(25.dp))
    )

}

@Preview(showBackground = true)
@Composable
fun ProfileButtonPreview() {
    ProfileButton(
        icon = painterResource(id = R.drawable.ic_credit_card),
        label = "Trade store",
        onClick = {},
        showEndArrow = true,
        showEndLabel = false
    )
}

@Composable
fun ProfileButton(
    icon: Painter,
    label: String,
    onClick: () -> Unit,
    showEndArrow: Boolean,
    showEndLabel: Boolean,
    endLabel: String = "$1593"
) {
    Row(
        Modifier
            .padding(bottom = 25.dp)
            .height(40.dp)
            .fillMaxWidth()
            .clickable { onClick() }

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically),
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(color = Color(0xffeeeff4), shape = CircleShape)
            ) {}

            Icon(
                painter = icon,
                contentDescription = "Navigation Icon $label"
            )
        }
        Text(
            text = label,
            color = Color(0xff040402),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            ),
            modifier = Modifier.align(Alignment.CenterVertically),
        )

        Spacer(Modifier.weight(1f))

        if (showEndArrow) {
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }

        if (showEndLabel) {
            Text(
                text = endLabel,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
            )
        }

    }
}

