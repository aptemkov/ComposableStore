package com.github.aptemkov.onlinestore.app.presentation.models

import com.github.aptemkov.onlinestore.R

data class FlashSaleItemData(
    val itemPhoto: Int,
    val category: String,
    val itemName: String,
    val itemPrice: String,
    val onLikeClicked: () -> Unit,
    val onAddClicked: () -> Unit,
)

val flashSaleList = listOf(
    FlashSaleItemData(
        itemPhoto = R.drawable.ic_launcher_background,
        category = "Kids",
        itemName = "New balance sneakers",
        itemPrice = "$180,000",
        onLikeClicked = {},
        onAddClicked = {}
    ),
    FlashSaleItemData(
        itemPhoto = R.drawable.ic_launcher_background,
        category = "Kids",
        itemName = "New balance sneakers",
        itemPrice = "$180,000",
        onLikeClicked = {},
        onAddClicked = {}
    ),
    FlashSaleItemData(
        itemPhoto = R.drawable.ic_launcher_background,
        category = "Kids",
        itemName = "New balance sneakers",
        itemPrice = "$180,000",
        onLikeClicked = {},
        onAddClicked = {}
    ),

)