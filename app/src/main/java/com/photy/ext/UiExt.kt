package com.photy.ext

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import java.util.*

private val GLIDE_TARGETS: MutableMap<ImageView, Target<*>> = WeakHashMap<ImageView, Target<*>>();

/**
 * Load image by url.
 *
 * @param imageUrl - image url.
 */
fun ImageView.loadUrl(imageUrl: String) {
  GLIDE_TARGETS.put(this, Glide.with(context).load(imageUrl).into(this)!!)
}

/**
 * Cancel previous image loading if exist.
 */
fun ImageView.cancelLoadUrl() { if (GLIDE_TARGETS.containsKey(this)) Glide.clear(GLIDE_TARGETS[this]) }

/**
 * extension for ViewGroup
 *
 * @param id - layout for inflate
 */
fun ViewGroup.inflate(@LayoutRes id : Int): View? = LayoutInflater.from(context).inflate(id, this, false)