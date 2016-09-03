package com.photy.ui.base.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.photy.App.Companion.appComponent
import kotlinx.android.synthetic.*

abstract class BaseFragment : Fragment() {

  @LayoutRes abstract fun getLayout(): Int

  abstract fun getPresenter(): BasePresenter<*>?

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectDependencies()
  }

  override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater?.inflate(getLayout(), container, false)
  }

  override fun onDetach() {
    super.onDetach()
    getPresenter()?.detachView()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    clearFindViewByIdCache()
  }

  private fun injectDependencies() {
    appComponent.inject(this)
  }
}