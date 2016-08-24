package com.photy.ext

import rx.Single
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers.io

inline fun <T> inBackground(f: () -> Single<T>): Single<T> {
  return f().subscribeOn(io()).observeOn(mainThread())
}