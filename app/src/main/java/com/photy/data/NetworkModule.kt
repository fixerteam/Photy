package com.photy.data

import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE
import com.photy.BuildConfig.API_URL
import com.photy.data.provider.CacheProvider
import com.photy.data.provider.NetworkProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module class NetworkModule {
  @Provides @Singleton fun provideJacksonMapper(): ObjectMapper =
      ObjectMapper().disable(FAIL_ON_UNKNOWN_PROPERTIES).setPropertyNamingStrategy(SNAKE_CASE)

  @Provides @Singleton fun provideOkHttpClient(): OkHttpClient =
      OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
          .build()

  @Provides @Singleton fun provideRetrofit(mapper: ObjectMapper, okHttpClient: OkHttpClient): NetworkProvider =
      Retrofit.Builder()
          .baseUrl(API_URL)
          .addConverterFactory(JacksonConverterFactory.create(mapper))
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .client(okHttpClient)
          .build()
          .create(NetworkProvider::class.java)

  @Provides @Singleton fun provideCache(): CacheProvider = object : CacheProvider {

  }
}