package com.github.aptemkov.onlinestore.app.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme

@Composable
fun HomePageScreen(
) {
    OnlineStoreTheme {
        MaterialTheme {
            Surface {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xffFAF9FF))
                        .wrapContentSize(align = Alignment.Center)
                        .padding(all = 48.dp),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "HOME"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomePagePreview() {
    HomePageScreen()
}

