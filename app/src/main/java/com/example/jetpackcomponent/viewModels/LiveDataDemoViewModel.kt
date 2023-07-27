package com.example.jetpackcomponent.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataDemoViewModel : ViewModel() {

    private val factsLiveDataObject = MutableLiveData("This is a fact")

    val factsLiveData : LiveData<String>
        get() = factsLiveDataObject

    fun chaneData(){

        factsLiveDataObject.value = "another fact"

    }

}