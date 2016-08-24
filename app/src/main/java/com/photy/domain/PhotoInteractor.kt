package com.photy.domain

import com.photy.BuildConfig
import com.photy.data.entity.Feature
import com.photy.data.entity.PhotosResponse
import com.photy.data.entity.Sort
import com.photy.data.repository.PhotoRepository
import com.photy.ext.arrayMapOf
import rx.Single
import javax.inject.Inject

class PhotoInteractor @Inject constructor(
    private val photoRepository: PhotoRepository) : BaseInteractor<PhotosResponse>() {

  override fun buildInteractionStream(): Single<PhotosResponse> =
      photoRepository.photos(arrayMapOf(
          "feature" to Feature.POPULAR.name,
          "sort" to Sort.RATING.name,
          "image_size" to "21",
          "page" to "1",
          "consumer_key" to BuildConfig.CONSUMER_KEY))
}