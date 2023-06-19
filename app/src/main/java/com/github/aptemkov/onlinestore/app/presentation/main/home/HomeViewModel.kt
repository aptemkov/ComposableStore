package com.github.aptemkov.onlinestore.app.presentation.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.aptemkov.onlinestore.domain.models.FlashSaleItemDomain
import com.github.aptemkov.onlinestore.domain.models.LatestItemDomain
import com.github.aptemkov.onlinestore.domain.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryDa: DataRepository
) : ViewModel() {

    private val _latest = MutableStateFlow<List<LatestItemDomain>>(listOf(
        LatestItemDomain("", "", "", "")
    ))
    val latest = _latest.asStateFlow()

    private val _flashSale =
        MutableStateFlow<List<FlashSaleItemDomain>>(listOf(
            FlashSaleItemDomain("", "", "", "0", "")
        ))
    val flashSale = _flashSale.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            val newLatestList = repositoryDa.getLatestList()
            _latest.value = newLatestList
        }

        viewModelScope.launch(Dispatchers.IO) {
            val newFlashSaleList = repositoryDa.getFlashSaleList()
            _flashSale.value = newFlashSaleList
        }

    }


}