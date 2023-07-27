package com.example.jetpackcomponent.quote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcomponent.R
import com.example.jetpackcomponent.databinding.ActivityQuoteMainBinding
import com.example.jetpackcomponent.randomUser.ApiInterface
import com.example.jetpackcomponent.randomUser.RetrofitHelper
import com.example.jetpackcomponent.randomUser.UserMainActivity
import com.example.jetpackcomponent.randomUser.UserRepository
import com.example.jetpackcomponent.randomUser.UserViewModel
import com.example.jetpackcomponent.randomUser.UserViewModelFactory

class QuoteMainActivity : AppCompatActivity() {

    private lateinit var mainBinding : ActivityQuoteMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_quote_main)

        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]


        mainViewModel.getQuotes().observe(this, Observer {
            mainBinding.quote = it.toString()
        })

        mainBinding.insertQuote.setOnClickListener {

            val quote = Quote(0, "This is testing", "Self")
            mainViewModel.insertQuote(quote)

        }

        mainBinding.userActivity.setOnClickListener {
            startActivity(Intent(this, UserMainActivity::class.java))
        }



    }
}