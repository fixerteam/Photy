package com.photy.ui.photos

import android.view.ViewGroup
import com.photy.R
import com.photy.data.entity.Photo
import com.photy.ext.loadUrl
import com.photy.ui.base.adapter.BaseHolder
import kotlinx.android.synthetic.main.i_photo.view.*

class PhotoHolder(parent: ViewGroup) : BaseHolder<Photo>(parent, R.layout.i_photo) {

  override fun bind(item: Photo) {
    itemView.image.loadUrl(item.imageUrl)
  }
}