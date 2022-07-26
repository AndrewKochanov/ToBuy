package com.example.tobuy.domain

interface BuyListRepository {

    fun getBuyList(): List<BuyItem>

    fun getBuyItem(buyItemId: Int): BuyItem

    fun addBuyItem(buyItem: BuyItem)

    fun deleteBuyItem(buyItem: BuyItem)

    fun editBuyItem(buyItem: BuyItem)
}