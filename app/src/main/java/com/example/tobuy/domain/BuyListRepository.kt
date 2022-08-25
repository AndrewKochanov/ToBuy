package com.example.tobuy.domain

import androidx.lifecycle.LiveData

interface BuyListRepository {

    fun getBuyList(): LiveData<List<BuyItem>>

    fun getBuyItem(buyItemId: Int): BuyItem

    fun addBuyItem(buyItem: BuyItem)

    fun deleteBuyItem(buyItem: BuyItem)

    fun editBuyItem(buyItem: BuyItem)
}