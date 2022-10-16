package com.example.myapplication.repo.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service(private val endpoints: Endpoints) {
    suspend fun user() = withContext(Dispatchers.IO) {
        try {
            endpoints.user().body()
        } catch (e: Exception) {
            Log.e("Retrofit", "${e.message}")
            null
        }
    }
}
