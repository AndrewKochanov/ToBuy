package com.example.tobuy.domain

class DeleteBuyItemUseCase(private val buyListRepository: BuyListRepository) {

    fun deleteBuyItem(buyItem: BuyItem) {
        buyListRepository.deleteBuyItem(buyItem)
    }
}