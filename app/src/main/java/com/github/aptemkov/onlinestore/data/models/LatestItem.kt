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

fun List<LatestItem>.asDomain(): List<LatestItemDomain> {
    return map {
        LatestItemDomain(
            category = it.category,
            name = it.name,
            price = it.price,
            image_url = it.image_url,
        )
    }
}