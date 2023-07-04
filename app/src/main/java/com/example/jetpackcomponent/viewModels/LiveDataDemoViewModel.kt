package com.example.jetpackcomponent.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataDemoViewModel : ViewModel() {

    val factsLiveData = MutableLiveData<String>("This is a fact")

    fun chaneData(){

        factsLiveData.value = "another fact"

    }

}