package com.photy.ui.base.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.photy.ui.base.adapter.ViewTypeConst.LOADING
import java.util.*

class BaseAdapter<in T : ViewType>() : RecyclerView.Adapter<ViewHolder>() {

  private val items by lazy { ArrayList<ViewType>() }
  private val adapters by lazy { SparseArrayCompat<ViewTypeDelegate>() }
  private val loadingItem = object : ViewType {
    override fun getViewType() = LOADING
  }

  constructor(vararg adapters: Pair<Int, ViewTypeDelegate>) : this() {
    adapters.forEach {
      this.adapters.put(it.first, it.second)
    }
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) =
      adapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])

  override fun getItemCount() = items.size

  override fun getItemViewType(position: Int) = items[position].getViewType()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
      adapters.get(viewType).onCreateViewHolder(parent)

  fun setItems(items: List<T>) {
    with(this.items) {
      clear()
      addAll(items)
      add(loadingItem)
    }
    notifyDataSetChanged()
  }

  fun addItems(items: List<T>) {
    var prev = 0
    if (itemCount > 0) {
      prev = this.items.size - 1
      this.items.removeAt(prev)
      notifyItemRemoved(prev)
    }
    this.items.addAll(items)
    this.items.add(loadingItem)
    notifyItemRangeInserted(prev, items.size + 1)
  }
}