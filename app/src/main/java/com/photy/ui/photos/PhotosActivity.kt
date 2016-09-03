package com.photy.ui.photos

import android.support.v7.widget.LinearLayoutManager
import com.photy.App.Companion.appComponent
import com.photy.R
import com.photy.data.entity.Photo
import com.photy.ui.base.adapter.BaseAdapter
import com.photy.ui.base.adapter.EndlessScrollListener
import com.photy.ui.base.adapter.LoadingAdapter
import com.photy.ui.base.adapter.ViewTypeConst.LOADING
import com.photy.ui.base.adapter.ViewTypeConst.PHOTO
import com.photy.ui.base.mvp.BaseActivity
import com.photy.ui.photos.PhotosPresenter.PhotosView
import com.photy.ui.photos.adapter.PhotosAdapter
import kotlinx.android.synthetic.main.w_photos.*
import org.jetbrains.anko.toast

class PhotosActivity : BaseActivity(), PhotosView {

  private val listAdapter by lazy {
    BaseAdapter<Photo>(LOADING to LoadingAdapter(), PHOTO to PhotosAdapter())
  }

  private lateinit var photoPresenter: PhotosPresenter

  override fun getLayout() = R.layout.w_photos

  override fun getPresenter() = photoPresenter

  override fun onViewCreated() {
    initPresenter()
    initRecyclerView()
  }

  override fun hideLoading() {
  }

  override fun showError(error: String) {
    toast(error)
  }

  override fun showLoading() {
  }

  override fun showPhotos(photos: List<Photo>) {
    listAdapter.addItems(photos)
  }

  private fun initRecyclerView() {
    val manager = LinearLayoutManager(this)
    list.layoutManager = manager
    list.addOnScrollListener(EndlessScrollListener(manager) { photoPresenter.loadMore() })
    list.adapter = listAdapter
  }

  private fun initPresenter() {
    photoPresenter = appComponent.getPhotoPresenter()
    photoPresenter.attachView(this)
    photoPresenter.init()
  }
}