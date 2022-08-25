package com.example.tobuy.domain

import androidx.lifecycle.LiveData

class GetBuyListUseCase(private val buyListRepository: BuyListRepository) {

    fun getBuyList(): LiveData<List<BuyItem>> {

        return buyListRepository.getBuyList()
    }
}