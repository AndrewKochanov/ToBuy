package com.example.tobuy.domain

class AddBuyItemUseCase(private val buyListRepository: BuyListRepository) {

    fun addBuyItem(buyItem: BuyItem) {
        buyListRepository.addBuyItem(buyItem)
    }
}