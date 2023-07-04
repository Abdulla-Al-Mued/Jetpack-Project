package com.example.jetpackcomponent.lifecycleAwareComponent

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MyObserver : DefaultLifecycleObserver {


    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("Observer", "OnCreate From My Observer")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("Observer", "OnResume From My Observer")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("Observer", "OnPause From My Observer")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("Observer", "OnDestroy From My Observer")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("Observer", "OnStart From My Observer")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("Observer", "OnStop From My Observer")
    }




}