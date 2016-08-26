package com.photy.ui.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

abstract class BaseAdapter<in T, VH : BaseHolder<T>> : RecyclerView.Adapter<VH>() {

  private val items by lazy { ArrayList<T>() }

  override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(items[position])

  override fun getItemCount() = items.size

  override abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

  fun setItems(items: List<T>) {
    this.items.clear()
    this.items.addAll(items)
    notifyDataSetChanged()
  }

  fun addItems(items: List<T>) {
    val prev = this.items.size
    this.items.addAll(items)
    notifyItemRangeInserted(prev, items.size)
  }
}