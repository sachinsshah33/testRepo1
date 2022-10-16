package com.example.myapplication.useCases

import com.example.myapplication.repo.local.models.UserLocal

interface IUserUseCase {
    suspend fun user(): UserLocal?
}