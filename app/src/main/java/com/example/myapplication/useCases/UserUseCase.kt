package com.example.myapplication.useCases

import com.example.myapplication.repo.IUserRepo
import com.example.myapplication.repo.UserRepo

class UserUseCase(private val repository: IUserRepo): IUserUseCase {
    override suspend fun user() = repository.user()
}