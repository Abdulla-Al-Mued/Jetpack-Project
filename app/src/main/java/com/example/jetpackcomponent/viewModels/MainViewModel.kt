package com.example.jetpackcomponent.viewModels

import androidx.lifecycle.ViewModel

class MainViewModel(private val initialValue : Int) : ViewModel() {

    var count: Int = initialValue
    var countString = count.toString()

    fun increment(){
        count++
        countString = count.toString()
    }

}