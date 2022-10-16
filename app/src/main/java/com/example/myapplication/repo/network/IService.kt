package com.example.myapplication.repo.network

import com.example.myapplication.repo.network.models.UserResponse

interface IService {
    suspend fun user(): UserResponse?
}