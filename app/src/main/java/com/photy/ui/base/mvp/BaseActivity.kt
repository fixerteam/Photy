package com.photy.ui.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

  @LayoutRes abstract fun getLayout(): Int

  abstract fun getPresenter(): BasePresenter<*>?

  abstract fun onViewCreated()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayout())
    injectDependencies()
    onViewCreated()
  }

  override fun onDestroy() {
    super.onDestroy()
    getPresenter()?.detachView()
  }

  private fun injectDependencies() {

  }
}