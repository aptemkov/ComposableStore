package com.github.aptemkov.onlinestore.domain.repository

import com.github.aptemkov.onlinestore.data.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.data.models.LatestItemList
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemListDomain
import retrofit2.Call

interface DataRepository {
    fun getLatestCall(): Call<LatestItemList>
    suspend fun getLatestList(): List<LatestItemDomain>
    fun getFlashSaleCall(): Call<FlashSaleItemList>
    suspend fun getFlashSaleList(): List<FlashSaleItemDomain>

}