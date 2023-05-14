package com.github.aptemkov.onlinestore.app.presentation.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
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
fun ProfilePageScreen(
) {
    val repo = AuthorizationRepositoryImpl(FirebaseAuth.getInstance())
    OnlineStoreTheme {
        MaterialTheme {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xffF5F5F5))
                        .wrapContentSize(align = Alignment.Center)
                        .padding(all = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {

                    ProfilePhoto(image = R.drawable.ic_launcher_background)

                    Text(
                        text = "Change photo",
                        color = Color(0xff808080),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = -0.3.sp
                        ),
                        modifier = Modifier
                            .width(width = 69.dp)
                            .height(height = 10.dp)
                    )

                    Text(
                        text = "Satria Adhi Pradana",
                        color = Color(0xff3f3f3f),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = -0.3.sp
                        ),
                        modifier = Modifier
                            .width(width = 168.dp)
                            .height(height = 16.dp)
                    )

                    ButtonAuth(text = "Upload item") {

                    }

                    Button(
                        onClick = { repo.signOut() }
                    ) {}
                }
            }
        }
    }
}


@Composable
fun ProfilePhoto(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
) {

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Profile icon",
        modifier = modifier
            .size(64.dp)
            .clip(shape = RoundedCornerShape(25.dp))
    )

}

@Preview(showBackground = true)
@Composable
fun ProfileButton() {
    Row(
        Modifier
            .background(color = Color(0xfffaf9ff))
            .fillMaxWidth()
            .padding(horizontal = 32.dp),

    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .background(color = Color(0xffeeeff4), shape = CircleShape)
            ) {}

            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "Navigation Icon text)"
            )
        }
        Text(
            text = "Trade store",
            color = Color(0xff040402),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
            ),
            modifier = Modifier.align(Alignment.CenterVertically),
        )
    }
}

