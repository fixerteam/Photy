package com.photy.data.provider

import com.photy.data.entity.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Single

interface NetworkProvider {
  @GET("v1/photos") fun photos(@QueryMap query: Map<String, String>): Single<PhotosResponse>
}