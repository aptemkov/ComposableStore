package com.github.aptemkov.onlinestore.data.repository

import android.util.Log
import com.github.aptemkov.onlinestore.data.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.data.models.LatestItemList
import com.github.aptemkov.onlinestore.data.api.StoreApiService
import com.github.aptemkov.onlinestore.data.models.asDomain
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemDomain
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemListDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemListDomain
import com.github.aptemkov.onlinestore.domain.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepositoryImpl @Inject constructor(
    private val apiService: StoreApiService
): DataRepository {

    fun getLatestCall(): Call<LatestItemList> {
        return apiService.getLatestCall()
    }

    fun getFlashSaleCall(): Call<FlashSaleItemList> {
        return apiService.getFlashSaleCall()
    }

    override suspend fun getLatestList(): List<LatestItemDomain> {
        return try {
            val newlist = apiService.getLatestList()
            withContext(Dispatchers.Main) {
                Log.i(API, "List: $newlist")
                newlist.latest.asDomain()
            }

        } catch (e: Exception) {
            Log.i(API, "Exception: ${e.message}")
            listOf()
        }
    }

    override suspend fun getFlashSaleList(): List<FlashSaleItemDomain> {

        return try {
            val newlist = apiService.getFlashSaleList()
            withContext(Dispatchers.Main) {
                Log.i(API, "List: $newlist")
                newlist.flash_sale.asDomain()
            }

        } catch (e: Exception) {
            Log.i(API, "Exception: ${e.message}")
            listOf()
        }

    }

}

const val API = "API_LOG"