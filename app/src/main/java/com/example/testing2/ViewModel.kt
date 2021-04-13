package com.example.testing2

import android.app.Application
import android.util.Log
import androidx.lifecycle.*

class ViewModel(application: Application): AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val itemRepository: ItemRepository = ItemRepository(context)
    val isItemFavorite: MutableLiveData<Boolean> = itemRepository.getFavoriteItem()
    private val TAG = ViewModel::class.java.simpleName


    fun saveInFavorite(favorite: DataClass) {
        itemRepository.saveFavoriteItem(favorite)
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Save Favorite ${itemRepository.getFavoriteItem().value}")
    }

    fun removeFromFavorite(){
        itemRepository.removeFavoriteItem()
        isItemFavorite.value = itemRepository.getFavoriteItem().value
        Log.i(TAG, "Remove Favorite ${itemRepository.getFavoriteItem().value}")
    }
}