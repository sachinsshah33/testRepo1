package com.example.myapplication.repo.network

import com.example.myapplication.repo.network.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET


interface Endpoints {
    @GET("user.json")
    suspend fun user(): Response<UserResponse>
}
