package com.github.aptemkov.onlinestore.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme

@Composable
fun HomePageScreen(
) {
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

                }


            }
        }
    }
}
