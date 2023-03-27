package com.alina.taskapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url:String?){
//    Picasso.get().load(url).into(this)
    Glide.with(this).load(url).into(this)
}

