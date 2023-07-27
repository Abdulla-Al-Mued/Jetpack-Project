package com.example.jetpackcomponent.randomUser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import com.example.jetpackcomponent.R
import com.example.jetpackcomponent.randomUser.model.Result

class UserAdapter(private val userList: List<Result>, private val context : Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        Toast.makeText(parent.context, "adapter called"+ userList.size, Toast.LENGTH_SHORT).show()
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.email.text = currentItem.email
        holder.itemNameTextView.text = currentItem.name.first + currentItem.name.last
        Toast.makeText(context, "adapter called"+ userList.size, Toast.LENGTH_SHORT).show()

    }


    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val itemNameTextView: TextView = itemView.findViewById(R.id.name)
        val email : TextView = itemView.findViewById(R.id.email)

    }
}