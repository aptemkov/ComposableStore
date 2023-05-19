package com.github.aptemkov.onlinestore.app.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R

@Preview
@Composable
fun DefaultTopAppBarPreview() {
    DefaultTopAppBar(
        showStartIcon = false,
        startIcon = painterResource(id = R.drawable.arrow_back),
        label = "Profile",
        showEndIcon = false,
        onClick = {}
    )
}

@Composable
fun DefaultTopAppBar(
    showStartIcon: Boolean = false,
    startIcon: Painter = painterResource(id = R.drawable.arrow_back),
    label: String,
    showEndIcon: Boolean = false,
    onClick: ()-> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xffFAF9FF))
    ) {
        if (showStartIcon) {
            Column(
                Modifier
                    .height(56.dp)
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = startIcon,
                    contentDescription = "",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { onClick() },
                )
            }

        }

        TopAppBar(

            backgroundColor = Color(0xffFAF9FF),
            elevation = 0.dp,

            title = {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    /*Text(
                        fontWeight = FontWeight.Bold,
                        text = label,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                    )*/
                    Text(
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f),
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold)
                            ) { append("Trade by ") }
                            withStyle(style = SpanStyle(
                                color = Color(0xff4e55d7),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold)) { append("aptemkov")}
                        }
                    )
                }
            },
            modifier = Modifier
                .height(56.dp)
                .weight(1f)
        )

        if (showEndIcon) {
            Column(
                Modifier
                    .height(56.dp)
                    .padding(end = 46.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Profile icon",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(shape = RoundedCornerShape(25.dp))
                        .border(
                            width = 1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(25.dp)
                        )

                )
            }
        }

    }
}