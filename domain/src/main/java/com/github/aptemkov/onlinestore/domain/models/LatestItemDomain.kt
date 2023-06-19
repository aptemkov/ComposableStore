package com.github.aptemkov.onlinestore.domain.models



data class LatestItemDomain(
    val category: String,
    val name: String,
    val price: String,
    val image_url: String
)

data class LatestItemListDomain(
    val latest: List<LatestItemDomain>,
)