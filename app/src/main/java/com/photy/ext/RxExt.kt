package com.photy.ext

import rx.Observable
import rx.android.schedulers.AndroidSchedulers.mainThread
import rx.schedulers.Schedulers.io

inline fun <T> inBackground(f: () -> Observable<T>): Observable<T> {
  return f().subscribeOn(io()).observeOn(mainThread())
}