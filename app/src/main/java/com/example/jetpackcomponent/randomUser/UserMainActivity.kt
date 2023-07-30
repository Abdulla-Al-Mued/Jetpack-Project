package com.example.jetpackcomponent.randomUser

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponent.R
import com.example.jetpackcomponent.connectivity.NetworkConnectivity
import com.example.jetpackcomponent.randomUser.model.Result

class UserMainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList : ArrayList<Result>
    private lateinit var userViewModel: UserViewModel
    private lateinit var networkConnectivity: NetworkConnectivity
    private lateinit var networkText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        userList = ArrayList()

        recyclerView = findViewById(R.id.userRecView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(userList, this)
        recyclerView.adapter = userAdapter
        networkText = findViewById(R.id.networkState)

        networkConnectivity = NetworkConnectivity(application)

        networkConnectivity.observe(this, Observer { isAvailable ->

            when(isAvailable)
            {
                true-> networkText.text = "Connction Avilable"
                else -> networkText.text = "Connection Lost"
            }

        })


        userViewModel = ViewModelProvider(this, UserViewModelFactory(
            UserRepository(RetrofitHelper.getInstance().create(ApiInterface::class.java))
        )
        )[UserViewModel::class.java]


        userViewModel.users.observe(this, Observer {

            val userInfo = it.results
//            userList = userInfo
            userList.clear()
            userList.addAll(userInfo)

            // Initialize the adapter after receiving the data

//            Toast.makeText(this, ""+userList.size, Toast.LENGTH_SHORT).show()

            // Notify the adapter that data has changed (if needed)
            userAdapter.notifyDataSetChanged()
            //Log.d("yo Nigga", userInfo.toString())
            userInfo.forEach{result ->
                Log.d("User Item", result.name.first + result.name.last)
            }


        })



    }
}