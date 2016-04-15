package com.photy

import android.app.Application
import com.photy.data.api.ApiModule
import com.photy.AppComponent

class App : Application() {

  companion object {
    @JvmStatic lateinit var appComponent: AppComponent
  }

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder()
        .apiModule(ApiModule())
        .build()
  }
}