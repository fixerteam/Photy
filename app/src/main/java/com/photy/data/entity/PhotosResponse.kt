package com.photy.data.entity

class PhotosResponse {
  var currentPage: Int = 0
  var totalPages: Int = 0
  var totalItems: Int = 0
  var photos: List<Photo> = emptyList()
}

class Photo {
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