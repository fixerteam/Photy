package com.photy.ui.photos

import com.photy.App.Companion.appComponent
import com.photy.R
import com.photy.data.entity.Photo
import com.photy.ui.base.BaseActivity
import com.photy.ui.photos.PhotosPresenter.PhotosView
import org.jetbrains.anko.toast

class PhotosActivity : BaseActivity(), PhotosView {

  lateinit var photoPresenter: PhotosPresenter

  override fun getLayout() = R.layout.w_photos

  override fun getPresenter() = photoPresenter

  override fun onViewCreated() {
    photoPresenter = appComponent.getPhotoPresenter()
    photoPresenter.attachView(this)
    photoPresenter.init()
  }

  override fun hideLoading() {

  }

  override fun showError(error: String) {
    toast(error)
  }

  override fun showLoading() {

  }

  override fun showPhotos(photos: List<Photo>) {

  }
}