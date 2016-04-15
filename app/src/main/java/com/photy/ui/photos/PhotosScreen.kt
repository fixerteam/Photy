package com.photy.ui.photos

import android.os.Parcel
import android.os.Parcelable

class PhotosScreen : Parcelable {
  override fun writeToParcel(dest: Parcel?, flags: Int) {}

  override fun describeContents(): Int = 0

  companion object {
    val CREATOR = object : Parcelable.Creator<PhotosScreen> {
      override fun createFromParcel(source: Parcel?): PhotosScreen = PhotosScreen()
      override fun newArray(size: Int): Array<out PhotosScreen>? = Array(size, { PhotosScreen() })
    }
  }
}