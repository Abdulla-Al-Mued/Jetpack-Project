package com.example.jetpackcomponent.randomUser.hiltUtils

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ActivityComponent

@HiltAndroidApp
class UserApplication : Application() {

    lateinit var applicationComponent: ActivityComponent

    override fun onCreate() {
        super.onCreate()
    }

}