package com.photy.ext

import android.support.v4.util.ArrayMap

fun <K, V> arrayMapOf(vararg values: Pair<K, V>): ArrayMap<K, V> {
  val map = ArrayMap<K, V>(values.size)
  map.putAll(values)
  return map
}