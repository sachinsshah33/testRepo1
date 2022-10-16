package com.example.myapplication.di

import com.example.myapplication.repo.UserRepo
import com.example.myapplication.useCases.UserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideUserUseCase(repository: UserRepo) = UserUseCase(repository)
}