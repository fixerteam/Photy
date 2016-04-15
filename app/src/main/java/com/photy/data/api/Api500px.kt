package com.photy.data.api

import com.photy.data.api.entity.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Observable

interface Api500px {
  @GET("v1/photos") fun photos(@QueryMap query: Map<String, String>): Observable<PhotosResponse>
}