package com.madina.sampleapp.ui.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

fun ImageView.loadImageFromOtherRepo(path: String) {
    Glide.with(this)
        .load("${IMAGE_BASE_URL}$path")
        .into(this)
}

fun ImageView.loadImage(path: String) {
    Glide.with(this)
        .load(path)
        .into(this)
}
