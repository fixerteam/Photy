package com.photy.data.model.photos

import com.photy.BuildConfig.CONSUMER_KEY
import com.photy.data.api.Api500px
import com.photy.data.api.entity.PhotosResponse
import com.photy.ext.arrayMapOf
import com.photy.ext.inBackground
import rx.Observable
import javax.inject.Inject

class PhotosModel @Inject constructor(val api: Api500px) {
  fun photos(feature: Feature, sort: Sort, page: Int): Observable<PhotosResponse> =
      inBackground {
        api.photos(arrayMapOf(
            "feature" to feature.name,
            "sort" to sort.name,
            "image_size" to "21",
            "page" to page.toString(),
            "consumer_key" to CONSUMER_KEY)
        )
      }
}