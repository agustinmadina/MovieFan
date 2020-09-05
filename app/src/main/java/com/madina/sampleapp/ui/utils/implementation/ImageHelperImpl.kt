package com.madina.sampleapp.ui.utils.implementation

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.madina.sampleapp.application.SampleApp
import com.madina.sampleapp.ui.utils.interfaces.ImageHelper

class ImageHelperImpl(val context: SampleApp) : ImageHelper {

    companion object {
        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    override fun loadImage(path: String, imageView: ImageView) {
        Glide.with(context)
            .load("$IMAGE_BASE_URL$path")
//            .placeholder(R.drawable.popcorn_placeholder)
            .into(imageView)
    }
}