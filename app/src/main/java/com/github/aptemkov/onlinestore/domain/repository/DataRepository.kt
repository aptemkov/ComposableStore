package com.github.aptemkov.onlinestore.domain.repository

import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.domain.models.LatestItemList
import retrofit2.Call

interface DataRepository {
    fun getLatestList(): Call<LatestItemList>
    fun getFlashSaleList(): Call<FlashSaleItemList>

}