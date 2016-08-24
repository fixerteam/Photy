package com.photy.data.repository

import com.photy.data.entity.PhotosResponse
import com.photy.data.provider.CacheProvider
import com.photy.data.provider.NetworkProvider
import rx.Single
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val networkProvider: NetworkProvider,
    private val cacheProvider: CacheProvider) {

  fun photos(params: Map<String, String>): Single<PhotosResponse> =
      networkProvider.photos(params)
}