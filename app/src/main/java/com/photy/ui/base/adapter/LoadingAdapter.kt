package com.photy.ui.base.adapter

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.photy.R
import com.photy.ext.inflate

class LoadingAdapter : ViewTypeDelegate {

  override fun onCreateViewHolder(parent: ViewGroup) = LoadingHolder(parent)

  override fun onBindViewHolder(holder: ViewHolder, item: ViewType) {}

  class LoadingHolder(parent: ViewGroup) : ViewHolder(parent.inflate(R.layout.i_loading))
}