package com.github.aptemkov.onlinestore.domain.models

import com.github.aptemkov.onlinestore.data.models.LatestItem


data class LatestItemDomain(
    val category: String,
    val name: String,
    val price: String,
    val image_url: String
)

data class LatestItemListDomain(
    val latest: List<LatestItem>,
)