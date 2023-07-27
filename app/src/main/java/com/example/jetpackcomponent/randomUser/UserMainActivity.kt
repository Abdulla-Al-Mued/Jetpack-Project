package com.example.jetpackcomponent.randomUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackcomponent.R
import com.example.jetpackcomponent.randomUser.model.Result

class UserMainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList : List<Result>
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main)

        //userList = ArrayList()

        recyclerView = findViewById(R.id.userRecView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        userViewModel = ViewModelProvider(this, UserViewModelFactory(
            UserRepository(RetrofitHelper.getInstance().create(ApiInterface::class.java))
        )
        )[UserViewModel::class.java]


        userViewModel.users.observe(this, Observer {

            val userInfo = it.results
            userList = userInfo

            // Initialize the adapter after receiving the data
            userAdapter = UserAdapter(userList, this)
            recyclerView.adapter = userAdapter

            Toast.makeText(this, ""+userList.size, Toast.LENGTH_SHORT).show()

            // Notify the adapter that data has changed (if needed)
            userAdapter.notifyDataSetChanged()
            //Log.d("yo Nigga", userInfo.toString())
            userInfo.forEach{result ->
                Log.d("User Item", result.name.first + result.name.last)
            }


        })



    }
}