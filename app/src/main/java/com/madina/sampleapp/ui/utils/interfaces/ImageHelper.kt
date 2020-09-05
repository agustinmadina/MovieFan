package com.madina.sampleapp.ui.utils.interfaces

import android.widget.ImageView

interface ImageHelper {
    fun loadImageFromOtherRepo(path: String, imageView: ImageView)
    fun loadImage(path: String, imageView: ImageView)
}