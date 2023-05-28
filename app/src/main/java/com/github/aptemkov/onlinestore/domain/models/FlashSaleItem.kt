package com.github.aptemkov.onlinestore.domain.models

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