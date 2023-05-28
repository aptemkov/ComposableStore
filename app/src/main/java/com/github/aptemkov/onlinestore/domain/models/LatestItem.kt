package com.github.aptemkov.onlinestore.domain.models


data class LatestItem(
    val category: String,
    val name: String,
    val price: String,
    val image_url: String
)

data class LatestItemList(
    val latest: List<LatestItem>,
)