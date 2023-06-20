package com.github.aptemkov.onlinestore.data.api

import com.github.aptemkov.onlinestore.data.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.data.models.LatestItemList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://run.mocky.io/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface StoreApiService {

    @GET("a1c25c65-c699-4f72-bf66-85aa067c8355")
    fun getLatestCall(): Call<LatestItemList>

    @GET("a1c25c65-c699-4f72-bf66-85aa067c8355")
    suspend fun getLatestList(): LatestItemList

    @GET("9108378b-d3ed-4e52-86b3-3b6599972674")
    fun getFlashSaleCall(): Call<FlashSaleItemList>

    @GET("b5a08e53-c2f0-4ce8-bff3-34918b289ddc")
    suspend fun getFlashSaleList(): FlashSaleItemList

}