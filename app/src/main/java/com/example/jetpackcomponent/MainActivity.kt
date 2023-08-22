package com.example.jetpackcomponent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponent.dataClass.Post
import com.example.jetpackcomponent.dataClass.Quote
import com.example.jetpackcomponent.databinding.ActivityMainBinding
import com.example.jetpackcomponent.lifecycleAwareComponent.MyObserver
import com.example.jetpackcomponent.viewModelFactory.MainViewModelFactory
import com.example.jetpackcomponent.viewModels.LiveDataDemoViewModel
import com.example.jetpackcomponent.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var liveDataViewModel : LiveDataDemoViewModel
    val IMAGE_URL = "https://trybpoltd.com/oms/uploads/TMu0m6uJDl20230703105226.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycle.addObserver(MyObserver())
        Log.d("Observer", "OnCreate From Main Observer")


        val quoteObj  = Quote("Do or Do not. There is no try", "yoda")

        val post = Post(IMAGE_URL)

        liveDataViewModel = ViewModelProvider(this)[LiveDataDemoViewModel::class.java]
        viewModel = ViewModelProvider(this, MainViewModelFactory(5))[MainViewModel::class.java]


        mainBinding.quote = quoteObj
        mainBinding.post = post
        mainBinding.viewModel = viewModel
        mainBinding.lifecycleOwner = this
        mainBinding.mainViewModel = liveDataViewModel



    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Observer", "OnRestart From Main Observer")
    }



}