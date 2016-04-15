package com.photy.ui.base

import android.support.annotation.UiThread
import java.lang.ref.WeakReference

open class BasePresenter<M, V : BaseView<M>> {

  var viewRef : WeakReference<V>? = null

  @UiThread fun attachView(view: V) {
    viewRef = WeakReference(view)
  }

  @UiThread fun getView() = viewRef?.get()

  @UiThread fun isViewAttached() = viewRef?.get() != null

  @UiThread fun detachView() {
    viewRef?.clear()
    viewRef = null
  }
}