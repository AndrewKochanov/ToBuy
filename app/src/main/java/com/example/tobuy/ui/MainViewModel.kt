package com.example.tobuy.ui

import androidx.lifecycle.ViewModel
import com.example.tobuy.data.BuyListRepositoryIml
import com.example.tobuy.domain.BuyItem
import com.example.tobuy.domain.DeleteBuyItemUseCase
import com.example.tobuy.domain.EditBuyItemUseCase
import com.example.tobuy.domain.GetBuyListUseCase

class MainViewModel : ViewModel() {

    private val repository = BuyListRepositoryIml

    private val getBuyListUseCase = GetBuyListUseCase(repository)
    private val deleteBuyItemUseCase = DeleteBuyItemUseCase(repository)
    private val editBuyItemUseCase = EditBuyItemUseCase(repository)

    val buyList = getBuyListUseCase.getBuyList()

    fun deleteBuyItem(buyItem: BuyItem) {
        deleteBuyItemUseCase.deleteBuyItem(buyItem)
    }

    fun changeEnabledState(buyItem: BuyItem) {
        val newItem = buyItem.copy(enabled = !buyItem.enabled)
        editBuyItemUseCase.editBuyItem(newItem)
    }
}