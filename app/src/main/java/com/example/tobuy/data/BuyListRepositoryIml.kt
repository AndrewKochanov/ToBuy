package com.example.tobuy.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tobuy.domain.BuyItem
import com.example.tobuy.domain.BuyListRepository

object BuyListRepositoryIml : BuyListRepository {

    private val buyListLD = MutableLiveData<List<BuyItem>>()
    private val buyList = mutableListOf<BuyItem>()
    private  var autoIncrementId = 0


    init {
        for (i in 0 until 10){
            val item = BuyItem(" Name $i", i, true)
            addBuyItem(item)
        }
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
        updateList()
    }

    override fun deleteBuyItem(buyItem: BuyItem) {
        buyList.remove(buyItem)
        updateList()
    }

    override fun editBuyItem(buyItem: BuyItem) {
        val oldBuyItem = getBuyItem(buyItem.id)
        buyList.remove(oldBuyItem)
        addBuyItem(buyItem)
    }


    override fun getBuyList(): LiveData<List<BuyItem>> {
        return buyListLD
    }

    private fun updateList(){
        buyListLD.value = buyList.toList()
    }
}