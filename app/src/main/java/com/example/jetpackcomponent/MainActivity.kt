package com.example.jetpackcomponent

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponent.lifecycleAwareComponent.MyObserver
import com.example.jetpackcomponent.viewModelFactory.MainViewModelFactory
import com.example.jetpackcomponent.viewModels.LiveDataDemoViewModel
import com.example.jetpackcomponent.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var textCounter : TextView

    private val text2 : TextView
        get() = findViewById(R.id.text2)

    private lateinit var incrementBtn : Button

    private val btn2 : Button
        get() = findViewById(R.id.btn2)

    private lateinit var viewModel : MainViewModel
    private lateinit var liveDataViewModel : LiveDataDemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyObserver())
        Log.d("Observer", "OnCreate From Main Observer")


        liveDataViewModel = ViewModelProvider(this)[LiveDataDemoViewModel::class.java]


        textCounter = findViewById(R.id.counterTxt)
        incrementBtn = findViewById(R.id.counterBtn)
        viewModel = ViewModelProvider(this, MainViewModelFactory(5))[MainViewModel::class.java]

        setText()

        incrementBtn.setOnClickListener{
            viewModel.increment()
            setText()
        }


        liveDataViewModel.factsLiveData.observe(this, Observer {

            text2.text = it

        })

        btn2.setOnClickListener {
            liveDataViewModel.chaneData()
        }

    }

    private fun setText() {

        textCounter.text = viewModel.count.toString()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Observer", "OnRestart From Main Observer")
    }



}