package com.photy.domain

import rx.Single
import rx.SingleSubscriber
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers.io
import rx.subscriptions.Subscriptions

abstract class BaseInteractor<T> {

  private var subscription = Subscriptions.empty()

  /**
   * Запускает Observable в IO потоке
   * @param observable - что выполнить
   * @param subscriber - куда вернуть результат
   */
  protected fun execute(observable: Single<T>, subscriber: SingleSubscriber<T>) {
    subscription = observable
        .subscribeOn(io())
        .observeOn(mainThread())
        .subscribe(subscriber)
  }

  /**
   * Прерывает выполнение текущего Interactor
   */
  fun unsubscribe() {
    this.subscription.unsubscribe()
  }
}