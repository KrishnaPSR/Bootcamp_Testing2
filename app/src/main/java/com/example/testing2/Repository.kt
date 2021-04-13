package com.example.testing2

import android.content.Context

open class ItemRepository(context: Context) {

    private val modelClass: ModelClass = ModelClass(context)

    fun getFavoriteItem() = modelClass.getFavoriteItems()
    fun removeFavoriteItem() = modelClass.removeFavoriteItems()
    fun saveFavoriteItem(fav: DataClass) = modelClass.saveFavoriteItems(fav)
}