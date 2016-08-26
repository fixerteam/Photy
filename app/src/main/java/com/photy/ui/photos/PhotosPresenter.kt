package com.photy.ui.photos

import com.photy.data.entity.Photo
import com.photy.domain.PhotoInteractor
import com.photy.ui.base.mvp.BasePresenter
import com.photy.ui.base.mvp.BaseView
import com.photy.ui.photos.PhotosPresenter.PhotosView
import rx.SingleSubscriber
import javax.inject.Inject

class PhotosPresenter @Inject constructor(
    private val photoInteractor: PhotoInteractor) : BasePresenter<PhotosView>() {

  fun loadMore() {
    loadPhotoList()
  }

  override fun init() {
    loadPhotoList()
  }

  override fun detachView() {
    super.detachView()
    photoInteractor.unsubscribe()
  }

  private fun loadPhotoList() {
    getView()?.showLoading()
    photoInteractor.loadPopularPhotos(popularPhotoSubscriber())
  }

  private fun popularPhotoSubscriber() = object : SingleSubscriber<List<Photo>>() {
    override fun onSuccess(value: List<Photo>) {
      showContent(value)
    }

    override fun onError(error: Throwable?) {
      showError(error)
    }
  }

  private fun showContent(value: List<Photo>) {
    getView()?.hideLoading()
    getView()?.showPhotos(value)
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