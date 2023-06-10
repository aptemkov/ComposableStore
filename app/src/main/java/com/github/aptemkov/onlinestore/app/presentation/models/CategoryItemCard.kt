package com.github.aptemkov.onlinestore.app.presentation.models

import com.github.aptemkov.onlinestore.R

data class CategoryItemData(
    val icon: Int,
    val name: String,
    val onClick: () -> Unit
)

val categories = listOf(
    CategoryItemData(name = "Phones", icon = R.drawable.ic_phone, onClick = {}),
    CategoryItemData(name = "Headphones", icon = R.drawable.ic_headphones, onClick = {}),
    CategoryItemData(name = "Games", icon = R.drawable.ic_games, onClick = {}),
    CategoryItemData(name = "Cars", icon = R.drawable.ic_car, onClick = {}),
    CategoryItemData(name = "Furniture", icon = R.drawable.ic_furniture, onClick = {}),
    CategoryItemData(name = "Kids", icon = R.drawable.ic_kid, onClick = {}),
)