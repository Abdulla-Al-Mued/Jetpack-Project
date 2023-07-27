package com.example.jetpackcomponent.randomUser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpackcomponent.randomUser.model.UserInfo

class UserRepository(private val apiInterface: ApiInterface) {

    private val usersLiveData : MutableLiveData<UserInfo> = MutableLiveData()

    val users : LiveData<UserInfo>
        get() = usersLiveData


    suspend fun getUsers(users : Int){
        val result = apiInterface.getUsers(users)

        if (result.body() != null){
            usersLiveData.postValue(result.body())
        }

    }

}