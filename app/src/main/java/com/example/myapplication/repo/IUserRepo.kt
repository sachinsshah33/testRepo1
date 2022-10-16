package com.example.myapplication.repo

import com.example.myapplication.repo.local.models.UserLocal

interface IUserRepo {
    suspend fun user(): UserLocal?
}