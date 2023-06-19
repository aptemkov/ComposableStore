package com.github.aptemkov.onlinestore.domain.repository

import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemDomain

interface DataRepository {
    suspend fun getLatestList(): List<LatestItemDomain>
    suspend fun getFlashSaleList(): List<FlashSaleItemDomain>

}