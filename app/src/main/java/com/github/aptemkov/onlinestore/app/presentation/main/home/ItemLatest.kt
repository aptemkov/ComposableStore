package com.github.aptemkov.onlinestore.app.presentation.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.aptemkov.onlinestore.R

@Preview(showBackground = true)
@Composable
fun ItemLatestPreview() {
    ItemLatest(
        itemPhoto = painterResource(id = R.drawable.ic_launcher_background),
        category = "Phones",
        itemName = "Samsung S10",
        itemPrice = "$180,000",
        onAddClicked = {}
    )
}

@Composable
fun ItemLatest(
    itemPhoto: Painter, category: String, itemName: String, itemPrice: String,
    onAddClicked: () -> Unit
) {
    Box() {
        Image(
            painter = itemPhoto,
            contentDescription = "Item latest",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(width = 114.dp)
                .height(height = 149.dp)
                .clip(shape = RoundedCornerShape(9.dp))
        )

        Column(
            modifier = Modifier
                .align(alignment = BottomStart)
                .padding(start = 8.dp, bottom = 8.dp)
        ) {
            CategoryItem(category = category)
            ItemName(name = itemName)
            ItemPrice(price = itemPrice)
        }

        AddButtonInLatest(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clickable { onAddClicked() }
        )
    }
}


@Composable
fun CategoryItem(category: String) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .width(width = 36.dp)
            .height(height = 12.dp)
            .background(color = Color(0xffc4c4c4).copy(alpha = 0.85f))
    ) {
        Text(
            text = category,
            color = Color(0xff070604),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 6.sp, fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }

}

@Composable
fun ItemName(name: String) {
    Text(
        text = name, color = Color.White, style = TextStyle(
            fontSize = 9.sp, fontWeight = FontWeight.SemiBold
        ), modifier = Modifier.width(60.dp)
    )
}

@Composable
fun ItemPrice(price: String) {
    Text(
        text = price, color = Color.White, style = TextStyle(
            fontSize = 7.sp, fontWeight = FontWeight.SemiBold
        ), modifier = Modifier
            .width(width = 40.dp)
            .height(height = 9.dp)
    )
}

@Composable
fun AddButtonInLatest(modifier: Modifier = Modifier) {
    Box(
        modifier
            .padding(end = 8.dp, bottom = 8.dp)
            .clip(shape = RoundedCornerShape(9.dp))
            .size(20.dp)
            .background(Color(0xffE5E9EF).copy(alpha = 0.85f)),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "Plus",
            modifier = Modifier
                .size(12.dp)
                .align(Alignment.Center)
                .alpha(0.85f)
        )

    }
}

