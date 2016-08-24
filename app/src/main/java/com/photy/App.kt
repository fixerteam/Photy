package com.photy

import android.app.Application
import com.photy.data.NetworkModule

class App : Application() {

  companion object {
    @JvmStatic lateinit var appComponent: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .build()
  }
}