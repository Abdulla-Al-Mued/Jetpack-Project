package com.example.jetpackcomponent.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponent.viewModels.MainViewModel

class MainViewModelFactory(private val counter : Int ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(counter) as T
    }

}