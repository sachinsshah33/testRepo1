package com.example.myapplication.repo

import com.example.myapplication.repo.local.models.UserLocal
import com.example.myapplication.repo.network.Service

class UserRepository(private val service: Service) {
    suspend fun user() = service.user()?.run { UserLocal(this) }
}