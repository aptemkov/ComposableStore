package com.github.aptemkov.onlinestore.data.repository

import com.github.aptemkov.onlinestore.data.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.data.models.LatestItemList
import com.github.aptemkov.onlinestore.data.api.StoreApiService
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemListDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemListDomain
import com.github.aptemkov.onlinestore.domain.repository.DataRepository
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepositoryImpl @Inject constructor(
    private val apiService: StoreApiService
): DataRepository {

    override fun getLatestList(): Call<LatestItemList> {
        val a = apiService.getLatestCall()
        return apiService.getLatestCall()
    }

    override fun getFlashSaleList(): Call<FlashSaleItemList> {
        return apiService.getFlashSaleCall()
    }

}