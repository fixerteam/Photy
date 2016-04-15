package com.photy.data.api

import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import com.photy.BuildConfig.API_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module class ApiModule {
  @Provides @Singleton fun provideJacksonMapper() =
      ObjectMapper().disable(FAIL_ON_UNKNOWN_PROPERTIES)

  @Provides @Singleton fun provideOkHttpClient() =
      OkHttpClient.Builder()
          .addInterceptor(HttpLoggingInterceptor().setLevel(BODY))
          .build()

  @Provides @Singleton fun provideRetrofit(mapper: ObjectMapper, okHttpClient: OkHttpClient) =
      Retrofit.Builder()
          .baseUrl(API_URL)
          .addConverterFactory(JacksonConverterFactory.create(mapper))
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .client(okHttpClient)
          .build()
          .create(Api500px::class.java)
}