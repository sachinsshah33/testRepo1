package com.example.myapplication.di

import com.example.myapplication.repo.UserRepo
import com.example.myapplication.repo.network.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(service: Service) = UserRepo(service)
}