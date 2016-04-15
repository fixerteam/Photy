package com.photy.ui

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.photy.R
import com.photy.ui.base.flow.FlowDispatcher
import com.photy.ui.photos.PhotosScreen
import flow.Flow

class PhotyActivity : AppCompatActivity() {

  override fun attachBaseContext(newBase: Context?) {
    val base = Flow.configure(newBase, this)
        .dispatcher(FlowDispatcher(this))
        .defaultKey(PhotosScreen())
        .install()
    super.attachBaseContext(base)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.a_main)
  }

  override fun onBackPressed() {
    if (!Flow.get(this).goBack()) {
      super.onBackPressed()
    }
  }
}