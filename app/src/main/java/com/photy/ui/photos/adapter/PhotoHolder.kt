package com.photy.ui.photos.adapter

import android.view.ViewGroup
import android.widget.ImageView
import com.photy.R
import com.photy.data.entity.Photo
import com.photy.ext.cancelLoadUrl
import com.photy.ext.loadUrl
import com.photy.ui.base.adapter.BaseHolder
import kotlinx.android.synthetic.main.i_photo.view.*

class PhotoHolder(parent: ViewGroup) : BaseHolder<Photo>(parent, R.layout.i_photo) {
  private val imageView: ImageView

  init { imageView = itemView.image }

  override fun bind(item: Photo) {
    imageView.cancelLoadUrl()
    imageView.loadUrl(item.imageUrl)
  }
}