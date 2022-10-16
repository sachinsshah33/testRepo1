package com.example.myapplication.useCases

import com.example.myapplication.repo.UserRepository

class UserUseCase(private val repository: UserRepository) {
    suspend fun user() = repository.user()
}