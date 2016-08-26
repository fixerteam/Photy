package com.photy.ui.base.mvp

interface BaseView {

  fun showLoading()

  fun hideLoading()

  fun showError(error: String)
}