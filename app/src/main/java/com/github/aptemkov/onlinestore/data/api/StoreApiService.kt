package com.github.aptemkov.onlinestore.data.api

import com.github.aptemkov.onlinestore.app.BASE_URL
import com.github.aptemkov.onlinestore.data.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.data.models.LatestItemList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface StoreApiService {

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    fun getLatestCall(): Call<LatestItemList>

    @GET("cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatestList(): LatestItemList

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    fun getFlashSaleCall(): Call<FlashSaleItemList>

    @GET("a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSaleList(): FlashSaleItemList

}


object StoreApi {
    val retrofitService: StoreApiService by lazy { retrofit.create(StoreApiService::class.java) }
}