package com.example.tobuy.domain

class EditBuyItemUseCase(private val buyListRepository: BuyListRepository) {

    fun editBuyItem(buyItem: BuyItem) {

        buyListRepository.editBuyItem(buyItem)
    }
}