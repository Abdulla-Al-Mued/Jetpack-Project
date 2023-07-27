package com.example.jetpackcomponent.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }

}