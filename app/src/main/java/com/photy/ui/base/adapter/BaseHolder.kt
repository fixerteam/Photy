package com.photy.ui.base.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseHolder<in T> (itemView: View) : RecyclerView.ViewHolder(itemView) {

  constructor(parent: ViewGroup, @LayoutRes layout: Int) : this(
      LayoutInflater.from(parent.context).inflate(layout, parent, false))

  abstract fun bind(item: T)
}