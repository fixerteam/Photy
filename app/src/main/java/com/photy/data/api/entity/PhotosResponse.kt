package com.photy.data.api.entity

import com.photy.data.model.photos.Photo

class PhotosResponse {
  var currentPage: Int = 0
  var totalPages: Int = 0
  var totalItems: Int = 0
  var photos: List<Photo> = emptyList()
}