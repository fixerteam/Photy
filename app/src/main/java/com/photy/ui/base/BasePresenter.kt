package com.photy.ui.base

import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView> {

  private var viewRef : WeakReference<V>? = null

  abstract fun init()

  fun attachView(view: V) {
    viewRef = WeakReference(view)
  }

  fun detachView() {
    viewRef?.clear()
    viewRef = null
  }

  protected fun getView() = viewRef?.get()
}