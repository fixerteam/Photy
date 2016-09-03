package com.photy.ui.base.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.photy.ext.inflate

abstract class BaseHolder<in T : ViewType>(itemView: View?) : RecyclerView.ViewHolder(itemView) {

  constructor(parent: ViewGroup, @LayoutRes layout: Int) : this(parent.inflate(layout))

  abstract fun bind(item: T)
}