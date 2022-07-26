package com.example.tobuy.domain

class GetBuyItemUseCase(private val buyListRepository: BuyListRepository) {

    fun getBuyItem(buyItemId: Int): BuyItem {

        return  buyListRepository.getBuyItem(buyItemId)
    }
}