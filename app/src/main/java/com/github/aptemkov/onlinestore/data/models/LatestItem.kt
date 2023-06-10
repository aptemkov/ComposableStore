package com.github.aptemkov.onlinestore.data.models

import com.github.aptemkov.onlinestore.domain.models.LatestItemDomain


data class LatestItem(
    val category: String,
    val name: String,
    val price: String,
    val image_url: String
)

data class LatestItemList(
    val latest: List<LatestItem>,
)

fun LatestItem.mapToDomain(): LatestItemDomain {
    return LatestItemDomain(
        category = this.category,
        name = this.name,
        price = this.price,
        image_url = this.image_url,
    )
}