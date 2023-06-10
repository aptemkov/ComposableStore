package com.github.aptemkov.onlinestore.domain.models

import com.github.aptemkov.onlinestore.data.models.FlashSaleItem
import com.github.aptemkov.onlinestore.data.models.LatestItem

data class FlashSaleItemDomain(
    val category: String,
    val name: String,
    val price: String,
    val discount: String,
    val image_url: String
)

data class FlashSaleItemListDomain(
    val flash_sale : List<FlashSaleItem>,
)

fun FlashSaleItem.mapToDomain(): FlashSaleItemDomain {
    return FlashSaleItemDomain(
        category = this.category,
        name = this.name,
        price = this.price,
        image_url = this.image_url,
        discount = this.discount,
    )
}