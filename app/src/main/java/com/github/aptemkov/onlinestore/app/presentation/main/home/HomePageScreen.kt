package com.github.aptemkov.onlinestore.app.presentation.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R
import com.github.aptemkov.onlinestore.app.presentation.main.DefaultTopAppBar
import com.github.aptemkov.onlinestore.ui.theme.OnlineStoreTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePageScreen(
) {
    OnlineStoreTheme {
        MaterialTheme {
            Scaffold(
                topBar = {
                    DefaultTopAppBar(
                        label = "Trade by A",
                        showStartIcon = true,
                        startIcon = painterResource(id = R.drawable.ic_menu),
                        showEndIcon = true,
                        onClick = {}
                    )
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xffFAF9FF))
                        .padding(horizontal = 12.dp),

                ) {
                    Spacer(modifier = Modifier.height(56.dp))

                    SearchBar()

                    LazyRow(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 40.dp)) {

                        items(count = 1) { it ->
                            CategoryItem("Phones",icon = painterResource(id = R.drawable.ic_phone), {})
                            CategoryItem("Headphones",icon = painterResource(id = R.drawable.ic_headphones),  {})
                            CategoryItem("Games",icon = painterResource(id = R.drawable.ic_games), {})
                            CategoryItem("Cars", icon = painterResource(id = R.drawable.ic_car), {})
                            CategoryItem("Furniture", icon = painterResource(id = R.drawable.ic_furniture), {})
                            CategoryItem("Kids", icon = painterResource(id = R.drawable.ic_kid), {})
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun SearchBar() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        shape = MaterialTheme.shapes.medium.copy(all = CornerSize(24.dp)),
        modifier = Modifier
            .padding(horizontal = 56.dp)
            .fillMaxWidth(),
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "What are you looking for?",
                textAlign = TextAlign.Center
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xff5B5B5B),
            containerColor = Color(0xffF5F6F6),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,

            ),
        trailingIcon = {Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "Search button")
        }

    )
}

//@Preview
@Composable
fun CategoryItemPreview() {
    CategoryItem(name = "Phones", icon = painterResource(id = R.drawable.ic_help), onClick = {})
}
@Composable
fun CategoryItem(name: String, icon: Painter, onClick: () -> Unit) {
    Column(Modifier.clickable { onClick() }) {
        Box(
            modifier = Modifier
                .padding(bottom = 11.dp)
                .size(42.dp)
                .background(color = Color(0xffEEEFF4), shape = CircleShape),
        ) {
            Icon(
                painter = icon,
                contentDescription = name,
                modifier = Modifier.size(24.dp).align(Alignment.Center)
            )
        }
        Text(
            text = name,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = TextStyle(color = Color(0xffA6A7AB), fontSize = 9.sp),
        )
    }

}

data class CategoryItemData(
    val icon: Int,
    val name: String,
    val onClick: () -> Unit
)

val categories = listOf(
    CategoryItemData(R.drawable.ic_headphones, "", {})
)

@Preview
@Composable
fun HomePagePreview() {
    HomePageScreen()
}

