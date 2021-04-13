package com.example.testing2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val application = this.application
        viewModel = ViewModelProviders.of(this).get(ViewModel(application)::class.java)
        setupUI()
        setListeners()
    }

    private fun setListeners() {
        favorite_BTN.setOnClickListener {
            if (CB_Favorite.isChecked) {
                viewModel.removeFromFavorite()
                Log.i(TAG, "UnChecked")
            }
            else {
                viewModel.saveInFavorite(DataClass(textView.text.toString(), true))
                Log.i(TAG, "Checked")
            }
        }
    }
    private fun setupUI() {
        viewModel.isItemFavorite.observe(this, Observer {
            CB_Favorite.isChecked = it
        })
    }
}