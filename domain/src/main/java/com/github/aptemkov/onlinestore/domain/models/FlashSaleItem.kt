package com.github.aptemkov.onlinestore.domain.models

data class FlashSaleItemDomain(
    val category: String,
    val name: String,
    val price: String,
    val discount: String,
    val image_url: String
)

data class FlashSaleItemListDomain(
    val flash_sale : List<FlashSaleItemDomain>,
)
