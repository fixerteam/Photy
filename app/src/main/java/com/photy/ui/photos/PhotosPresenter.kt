package com.photy.ui.photos

import com.photy.data.entity.Photo
import com.photy.data.entity.PhotosResponse
import com.photy.domain.PhotoInteractor
import com.photy.ui.base.BasePresenter
import com.photy.ui.base.BaseView
import com.photy.ui.photos.PhotosPresenter.PhotosView
import rx.SingleSubscriber
import javax.inject.Inject

class PhotosPresenter @Inject constructor(
    private val photoInteractor: PhotoInteractor) : BasePresenter<PhotosView>() {

  override fun init() {
    loadPhotoList()
  }

  private fun loadPhotoList() {
    getView()?.showLoading()
    photoInteractor.execute(object : SingleSubscriber<PhotosResponse>() {
      override fun onSuccess(value: PhotosResponse?) {
        showContent(value)
      }

      override fun onError(error: Throwable?) {
        showError(error)
      }
    })
  }

  private fun showContent(value: PhotosResponse?) {
    getView()?.hideLoading()

    if (value != null) {
      getView()?.showPhotos(value.photos)
    }
  }

  private fun showError(error: Throwable?) {
    getView()?.hideLoading()

    val message = error?.message
    if (message != null) {
      getView()?.showError(message)
    }
  }

  interface PhotosView : BaseView {

    fun showPhotos(photos: List<Photo>)
  }
}