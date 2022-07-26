package com.example.tobuy.domain

class GetBuyItemListUseCase(private val buyListRepository: BuyListRepository) {

    fun getBuyItemList(): List<BuyItem> {

        return buyListRepository.getBuyList()
    }
}