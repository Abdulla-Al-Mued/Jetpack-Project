package com.example.jetpackcomponent.randomUser

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomponent.randomUser.model.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsers(8)
        }
    }

    val users : LiveData<UserInfo>
        get() = repository.users

}