package com.github.aptemkov.onlinestore.app.presentation.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun ItemFlashSalePreview() {
    ItemFlashSale(
        itemPhoto = painterResource(id = R.drawable.ic_launcher_background),
        category = "Kids",
        itemName = "New balance sneakers",
        itemPrice = "$180,000",
        onLikeClicked = {},
        onAddClicked = {}
    )
}

@Composable
fun ItemFlashSale(
    itemPhoto: Painter, category: String, itemName: String, itemPrice: String,
    onLikeClicked: () -> Unit, onAddClicked: () -> Unit) {
    Box {
        Image(
            painter = itemPhoto,
            contentDescription = "Item latest",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(width = 174.dp)
                .height(height = 221.dp)
                .clip(shape = RoundedCornerShape(9.dp))
        )

        Column(
            modifier = Modifier
                .align(alignment = BottomStart)
                .padding(start = 8.dp, bottom = 8.dp)
        ) {
            CategoryItemFlashSale(category = category)
            ItemNameFlashSale(name = itemName)
            ItemPriceFlashSale(price = itemPrice)
        }

        SaleLogo(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 8.dp, top = 8.dp)
        )
        Row(
            modifier = Modifier.align(Alignment.BottomEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LikeButton(modifier = Modifier, onClick = { onLikeClicked() })
            AddButton(modifier = Modifier, onClick =  { onAddClicked() })
        }

    }
}

@Composable
fun SaleLogo(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .width(width = 50.dp)
            .height(height = 18.dp)
            .background(color = Color(0xffF93A3A))
    ) {
        Text(
            text = "30% off",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 10.sp, fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun CategoryItemFlashSale(category: String) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .width(width = 50.dp)
            .height(height = 18.dp)
            .background(color = Color(0xffc4c4c4).copy(alpha = 0.85f))
    ) {
        Text(
            text = category,
            color = Color(0xff070604),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 9.sp, fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }

}

@Composable
fun ItemNameFlashSale(name: String) {
    Text(
        text = name, color = Color.White, style = TextStyle(
            fontSize = 13.sp, fontWeight = FontWeight.SemiBold
        ), modifier = Modifier.width(85.dp)
    )
}

@Composable
fun ItemPriceFlashSale(price: String) {
    Text(
        text = price, color = Color.White, style = TextStyle(
            fontSize = 10.sp, fontWeight = FontWeight.SemiBold
        ), modifier = Modifier
            .width(width = 85.dp)
    )
}

@Composable
fun AddButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier
            .padding(end = 8.dp, bottom = 8.dp)
            .clip(shape = RoundedCornerShape(18.dp))
            .size(36.dp)
            .background(Color(0xffE5E9EF).copy(alpha = 0.85f))
            .clickable { onClick() },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_add),
            contentDescription = "Plus",
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.Center)
                .alpha(0.85f)
        )

    }
}

@Composable
fun LikeButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier
            .padding(end = 8.dp, bottom = 8.dp)
            .clip(shape = RoundedCornerShape(14.dp))
            .size(28.dp)
            .background(Color(0xffE5E9EF).copy(alpha = 0.85f))
            .clickable { onClick() },
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_favourite),
            contentDescription = "Plus",
            modifier = Modifier
                .size(18.dp)
                .align(Alignment.Center)
                .alpha(0.85f)
        )

    }
}