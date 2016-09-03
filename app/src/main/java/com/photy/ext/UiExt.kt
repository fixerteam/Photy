package com.photy.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import java.util.WeakHashMap

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