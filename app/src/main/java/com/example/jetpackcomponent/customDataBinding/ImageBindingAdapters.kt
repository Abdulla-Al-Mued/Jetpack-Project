package com.example.jetpackcomponent.customDataBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun ImageView.imageFormUrl(url : String){

    Glide.with(this.context).load(url).into(this)

}