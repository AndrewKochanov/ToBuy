package com.example.tobuy.data

import com.example.tobuy.domain.BuyItem
import com.example.tobuy.domain.BuyListRepository

object BuyListRepositoryIml : BuyListRepository {

    private val buyList = mutableListOf<BuyItem>()
    private  var autoIncrementId = 0

    override fun getBuyList(): List<BuyItem> {
        return buyList.toList()
    }

    override fun getBuyItem(buyItemId: Int): BuyItem {
        // return  buyList.get(buyItemId)
        return buyList.find { it.id == buyItemId }
            ?: throw RuntimeException("Element with id $buyItemId not found")
    }

    override fun addBuyItem(buyItem: BuyItem) {
        if (buyItem.id == BuyItem.UNDEFINED_ID ) {
            buyItem.id = autoIncrementId++
        }
        buyList.add(buyItem)
    }

    override fun deleteBuyItem(buyItem: BuyItem) {
        buyList.remove(buyItem)
    }

    override fun editBuyItem(buyItem: BuyItem) {
        val oldBuyItem = getBuyItem(buyItem.id)
        buyList.remove(oldBuyItem)
        addBuyItem(buyItem)
    }


}