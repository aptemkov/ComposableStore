package com.github.aptemkov.onlinestore.domain.repository

import com.github.aptemkov.onlinestore.data.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.data.models.LatestItemList
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemListDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemListDomain
import retrofit2.Call

interface DataRepository {
    fun getLatestList(): Call<LatestItemList>
    fun getFlashSaleList(): Call<FlashSaleItemList>

}