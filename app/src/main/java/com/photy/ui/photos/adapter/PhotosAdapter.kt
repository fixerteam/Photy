package com.photy.ui.photos.adapter

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.photy.data.entity.Photo
import com.photy.ui.base.adapter.ViewType
import com.photy.ui.base.adapter.ViewTypeDelegate

class PhotosAdapter : ViewTypeDelegate {
  override fun onCreateViewHolder(parent: ViewGroup) = PhotoHolder(parent)

  override fun onBindViewHolder(holder: ViewHolder, item: ViewType) {
    holder as PhotoHolder
    holder.bind(item as Photo)
  }
}