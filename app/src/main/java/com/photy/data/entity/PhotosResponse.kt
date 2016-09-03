package com.photy.data.entity

import com.photy.ui.base.adapter.ViewType
import com.photy.ui.base.adapter.ViewTypeConst.PHOTO

class PhotosResponse {
  var currentPage: Int = 0
  var totalPages: Int = 0
  var totalItems: Int = 0
  var photos: List<Photo> = emptyList()
}

class Photo : ViewType {
  override fun getViewType() = PHOTO

  var id: Long = 0L
  var name: String = ""
  var description: String? = null
  var createdAt: String = ""
  var imageUrl: String = ""
  var rating: Int = 0
}

enum class Sort {
  CREATED_AT, RATING
}

enum class Feature {
  POPULAR, UPCOMING, FRESH_TODAY, FRESH_YESTERDAY, FRESH_WEEK
}