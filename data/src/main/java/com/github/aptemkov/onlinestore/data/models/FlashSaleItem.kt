package com.github.aptemkov.onlinestore.data.models

import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemDomain

data class FlashSaleItem(
    val category: String,
    val name: String,
    val price: String,
    val discount: String,
    val image_url: String
)

data class FlashSaleItemList(
    val flash_sale : List<FlashSaleItem>,
)

fun List<FlashSaleItem>.asDomain(): List<FlashSaleItemDomain> {
    return map {
        FlashSaleItemDomain(
            category = it.category,
            name = it.name,
            price = it.price,
            image_url = it.image_url,
            discount = it.discount
        )
    }
}
