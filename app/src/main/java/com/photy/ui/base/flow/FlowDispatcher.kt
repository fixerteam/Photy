package com.photy.ui.base.flow

import android.app.Activity
import android.support.annotation.LayoutRes
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.photy.R
import com.photy.ui.photos.PhotosScreen
import flow.Dispatcher
import flow.History
import flow.Traversal
import flow.TraversalCallback

class FlowDispatcher (private val activity: Activity) : Dispatcher {
  override fun dispatch(traversal: Traversal, callback: TraversalCallback) {
    val container = activity.findViewById(R.id.container) as ViewGroup
    TransitionManager.beginDelayedTransition(container)
    val destination = traversal.destination.top<Any>()

    if (traversal.origin != null && container.childCount > 0) {
      traversal.getState((traversal.origin as History).top()).save(container.getChildAt(0))
      container.removeAllViews()
    }

    @LayoutRes val layoutRes = when (destination) {
      is PhotosScreen -> R.layout.w_photos
      else -> throw IllegalStateException("Unknown screen $destination")
    }

    val incomingView = LayoutInflater.from(traversal.createContext(destination, activity))
        .inflate(layoutRes, container, false)

    container.addView(incomingView)
    traversal.getState(traversal.destination.top()).restore(incomingView)
    callback.onTraversalCompleted()
  }
}