package com.example.myapplication.di

import android.content.Context
import com.example.myapplication.BuildConfig
import com.example.myapplication.repo.network.Endpoints
import com.example.myapplication.repo.network.Service
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context) = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addNetworkInterceptor(Interceptor {
            val requestBuilder = it.request().newBuilder()
            requestBuilder.header("Content-Type", "application/json")
            it.proceed(requestBuilder.build())
        })
        .apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                })
            }
        }
        .build()


    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) =
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/rentELtd/iostest/master/")
            .client(okHttpClient)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter())
                        .add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()

    @Singleton
    @Provides
    fun provideEndpoints(
        retrofit: Retrofit
    ) = retrofit.create(Endpoints::class.java)

    @Singleton
    @Provides
    fun provideService(
        endpoints: Endpoints
    ) = Service(endpoints)
}