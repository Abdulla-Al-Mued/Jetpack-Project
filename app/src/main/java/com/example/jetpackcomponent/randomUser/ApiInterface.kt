package com.example.jetpackcomponent.randomUser

import com.example.jetpackcomponent.randomUser.model.UserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/")
    suspend fun getUsers(@Query("results") users : Int) : Response<UserInfo>

}