package com.github.aptemkov.onlinestore.app.presentation.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aptemkov.onlinestore.app.HOME_VIEW_MODEL
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItem
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemList
import com.github.aptemkov.onlinestore.domain.models.LatestItem
import com.github.aptemkov.onlinestore.domain.models.LatestItemList
import com.github.aptemkov.onlinestore.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryDa: DataRepository
): ViewModel() {

    private val _latest = MutableStateFlow<List<LatestItem>>(listOf())
    val latest = _latest.asStateFlow()

    private val _flashSale = MutableStateFlow<List<FlashSaleItem>>(listOf())
    val flashSale = _flashSale.asStateFlow()

    init {

        Log.d(HOME_VIEW_MODEL,"started")

        viewModelScope.launch {
            val call = repositoryDa.getLatestList()
            call.enqueue(object: Callback<LatestItemList> {

                override fun onResponse(call: Call<LatestItemList>, response: Response<LatestItemList>) {
                    Log.d(HOME_VIEW_MODEL,"${response.body()?.latest}")
                    if(response.body() != null) {
                        _latest.value = response.body()!!.latest
                    }
                }

                override fun onFailure(call: Call<LatestItemList>, t: Throwable) {
                    Log.d(HOME_VIEW_MODEL, "${t.message}")
                }

            })
        }

        viewModelScope.launch {
            val call = repositoryDa.getFlashSaleList()
            call.enqueue(object: Callback<FlashSaleItemList> {

                override fun onResponse(call: Call<FlashSaleItemList>, response: Response<FlashSaleItemList>) {
                    Log.d(HOME_VIEW_MODEL,"${response.body()?.flash_sale}")
                    if(response.body() != null) {
                        _flashSale.value = response.body()!!.flash_sale
                    }
                }

                override fun onFailure(call: Call<FlashSaleItemList>, t: Throwable) {
                    Log.d(HOME_VIEW_MODEL, "${t.message}")
                }

            })
        }

    }

}