package com.example.testing2

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class ModelClass(private val context: Context) {
    private val FAVORITE_KEY = "isFavorite"
    private val preferences: SharedPreferences = context.getSharedPreferences("favorite", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    fun getFavoriteItems(): MutableLiveData<Boolean> {
        return MutableLiveData(preferences.getBoolean(FAVORITE_KEY, false))
    }
    fun saveFavoriteItems(favorite: DataClass) {
        editor.putBoolean(FAVORITE_KEY, favorite.isFavorite)
        editor.commit()
        Toast.makeText(context, "Favorite Item Added", Toast.LENGTH_LONG).show()
    }
    fun removeFavoriteItems() {
        editor.remove(FAVORITE_KEY)
        editor.commit()
        Toast.makeText(context, "Favorite Item Removed", Toast.LENGTH_LONG).show()
    }
}