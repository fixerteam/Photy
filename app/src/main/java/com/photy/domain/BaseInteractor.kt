package com.photy.domain

import rx.Single
import rx.SingleSubscriber
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers.io
import rx.subscriptions.Subscriptions

abstract class BaseInteractor<T> {

  private var subscription = Subscriptions.empty()

  /**
   * Формирует {@link rx.Single} для получения и обработки данных для текущего Interactor
   */
  protected abstract fun buildInteractionStream(): Single<T>

  /**
   * Запускает текущий Interactor на выполнение
   */
  fun execute(subscriber: SingleSubscriber<T>) {
    subscription = buildInteractionStream()
        .subscribeOn(io())
        .observeOn(mainThread())
        .subscribe(subscriber)
  }

  /**
   * Прерывает выполнение текущего Interactor
   */
  fun unsubscribe() {
    subscription.unsubscribe()
  }
}