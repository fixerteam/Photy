package com.photy.domain

import com.photy.BuildConfig.CONSUMER_KEY
import com.photy.data.entity.Feature
import com.photy.data.entity.Feature.*
import com.photy.data.entity.Photo
import com.photy.data.entity.PhotosResponse
import com.photy.data.repository.PhotoRepository
import com.photy.ext.arrayMapOf
import rx.Single
import rx.Single.just
import rx.SingleSubscriber
import javax.inject.Inject

class PhotoInteractor @Inject constructor(
    private val photoRepository: PhotoRepository) : BaseInteractor<List<Photo>>() {

  private var currentPage = 1
  private var loadMore = true
  private var isLoading = false

  fun loadPopularPhotos(subscriber: SingleSubscriber<List<Photo>>) {
    load(POPULAR, subscriber)
  }

  fun loadUpcomingPhotos(subscriber: SingleSubscriber<List<Photo>>) {
    load(UPCOMING, subscriber)
  }

  fun loadFreshTodayPhotos(subscriber: SingleSubscriber<List<Photo>>) {
    load(FRESH_TODAY, subscriber)
  }

  fun loadFreshWeekPhotos(subscriber: SingleSubscriber<List<Photo>>) {
    load(FRESH_WEEK, subscriber)
  }

  fun loadFreshYesterdayPhotos(subscriber: SingleSubscriber<List<Photo>>) {
    load(FRESH_YESTERDAY, subscriber)
  }

  private fun load(feature: Feature, subscriber: SingleSubscriber<List<Photo>>) {
    if (needLoaded()) {
      execute(transformData(photoRepository.photos(arrayMapOf(
          "feature" to feature.name,
          "image_size" to "21",
          "page" to currentPage.toString(),
          "consumer_key" to CONSUMER_KEY))), subscriber)
    }
  }

  private fun needLoaded(): Boolean {
    if (loadMore && ! isLoading) {
      isLoading = true
      return true
    } else {
      return false
    }
  }

  private fun transformData(stream: Single<PhotosResponse>) =
      stream.flatMap {
        this.isLoading = false
        this.loadMore = currentPage <= it.totalPages
        this.currentPage ++
        return@flatMap just(it.photos)
      }

  private fun flushData() {
    currentPage = 1
    loadMore = true
    isLoading = false
  }
}