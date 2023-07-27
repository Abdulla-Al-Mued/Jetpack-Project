package com.example.jetpackcomponent.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel(initialValue : Int) : ViewModel() {

    private var count = MutableLiveData(initialValue)
    val countLiveData : LiveData<String>
        get() = count.map { it.toString() }

    fun increment(){
        count.value = (count.value?: 0) + 1
    }

}