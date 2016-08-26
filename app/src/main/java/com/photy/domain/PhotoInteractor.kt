package com.photy.domain

import com.photy.BuildConfig.CONSUMER_KEY
import com.photy.data.entity.Feature
import com.photy.data.entity.Photo
import com.photy.data.entity.Sort
import com.photy.data.repository.PhotoRepository
import com.photy.ext.arrayMapOf
import rx.Single.just
import rx.SingleSubscriber
import javax.inject.Inject

class PhotoInteractor @Inject constructor(
    private val photoRepository: PhotoRepository) : BaseInteractor<List<Photo>>() {

  private var currentPage = 1
  private var loadMore = true
  private var isLoading = false

  fun loadPopularPhotos(subscriber: SingleSubscriber<List<Photo>>, sortBy: Sort = Sort.CREATED_AT) {
    if (!loadMore) return
    if (isLoading) return

    isLoading = true
    execute(photoRepository.photos(arrayMapOf(
        "feature" to Feature.POPULAR.name,
        "sort" to sortBy.name,
        "image_size" to "21",
        "page" to currentPage.toString(),
        "consumer_key" to CONSUMER_KEY))
        .flatMap {
          this.isLoading = false
          this.loadMore = currentPage <= it.totalPages
          this.currentPage++
          return@flatMap just(it.photos)
        }, subscriber)
  }
}