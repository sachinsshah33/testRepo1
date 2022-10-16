package com.example.myapplication.useCases

import com.example.myapplication.repo.IUserRepo

class UserUseCase(private val repository: IUserRepo): IUserUseCase {
    override suspend fun user() = repository.user()
}