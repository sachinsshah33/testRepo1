package com.example.myapplication.repo

import com.example.myapplication.repo.local.models.UserLocal
import com.example.myapplication.repo.network.IService
import com.example.myapplication.repo.network.Service

class UserRepo(private val service: IService): IUserRepo {
    override suspend fun user() = service.user()?.run { UserLocal(this) }
}