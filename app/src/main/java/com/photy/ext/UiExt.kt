package com.photy.ext

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(imageUrl: String) {
  Glide.with(context).load(imageUrl).into(this)
}