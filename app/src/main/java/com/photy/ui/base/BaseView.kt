package com.photy.ui.base

import android.support.annotation.UiThread

interface BaseView<M> {

  @UiThread fun showLoading(pullToRefresh: Boolean)

  @UiThread fun showContent()

  @UiThread fun showError(error: Throwable, pullToRefresh: Boolean)

  @UiThread fun setData(data: M)

  @UiThread fun loadData(pullToRefresh: Boolean)
}