package com.photy.ui.base.adapter

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup

interface ViewTypeDelegate {

  fun onCreateViewHolder(parent: ViewGroup): ViewHolder

  fun onBindViewHolder(holder: ViewHolder, item: ViewType)
}