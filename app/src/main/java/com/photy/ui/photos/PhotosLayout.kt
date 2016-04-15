package com.photy.ui.photos

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.photy.data.model.photos.Photo

class PhotosLayout(context: Context, attr: AttributeSet) : PhotosView, RelativeLayout(context, attr) {

  override fun showLoading(pullToRefresh: Boolean) {
    throw UnsupportedOperationException()
  }

  override fun showContent() {
    throw UnsupportedOperationException()
  }

  override fun showError(error: Throwable, pullToRefresh: Boolean) {
    throw UnsupportedOperationException()
  }

  override fun setData(data: List<Photo>) {
    throw UnsupportedOperationException()
  }

  override fun loadData(pullToRefresh: Boolean) {
    throw UnsupportedOperationException()
  }
}