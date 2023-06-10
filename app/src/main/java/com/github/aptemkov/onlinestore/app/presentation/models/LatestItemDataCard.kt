package com.github.aptemkov.onlinestore.app.presentation.models

import com.github.aptemkov.onlinestore.R

data class LatestItemData(
    val itemPhoto: Int,
    val category: String,
    val itemName: String,
    val itemPrice: String,
    val onAddClicked: () -> Unit,
)

val latest = listOf(
    LatestItemData(
        itemPhoto = R.drawable.ic_launcher_background,
        category = "Phones",
        itemName = "Samsung S10",
        itemPrice = "$180,000",
        onAddClicked = {}
    ),
    LatestItemData(
        itemPhoto = R.drawable.ic_launcher_background,
        category = "Phones",
        itemName = "Samsung S10",
        itemPrice = "$180,000",
        onAddClicked = {}
    ),
    LatestItemData(
        itemPhoto = R.drawable.ic_launcher_background,
        category = "Phones",
        itemName = "Samsung S10",
        itemPrice = "$180,000",
        onAddClicked = {}
    )
)