package com.example.jetpackcomponent

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponent.dataClass.Quote
import com.example.jetpackcomponent.databinding.ActivityMainBinding
import com.example.jetpackcomponent.lifecycleAwareComponent.MyObserver
import com.example.jetpackcomponent.viewModelFactory.MainViewModelFactory
import com.example.jetpackcomponent.viewModels.LiveDataDemoViewModel
import com.example.jetpackcomponent.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var textCounter : TextView
    private lateinit var mainBinding : ActivityMainBinding

    private val text2 : TextView
        get() = findViewById(R.id.text2)

    private lateinit var incrementBtn : Button


    private lateinit var viewModel : MainViewModel
    private lateinit var liveDataViewModel : LiveDataDemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycle.addObserver(MyObserver())
        Log.d("Observer", "OnCreate From Main Observer")

        textCounter = findViewById(R.id.counterTxt)
        incrementBtn = findViewById(R.id.counterBtn)

        val quoteObj  = Quote("Do or Do not. There is no try", "yoda")
        mainBinding.quote = quoteObj

        liveDataViewModel = ViewModelProvider(this)[LiveDataDemoViewModel::class.java]
        viewModel = ViewModelProvider(this, MainViewModelFactory(5))[MainViewModel::class.java]

//        incrementBtn.setOnClickListener{
//            viewModel.increment()
//        }
        mainBinding.viewModel = viewModel


        mainBinding.lifecycleOwner = this
        mainBinding.mainViewModel = liveDataViewModel

    }

    private fun setText() {

        textCounter.text = viewModel.count.toString()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Observer", "OnRestart From Main Observer")
    }



}