package com.example.myapplication.viewModels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ui.models.UserUI
import com.example.myapplication.useCases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    application: Application,
    private val userUseCase: UserUseCase
) : BaseAndroidViewModel(application) {

    var user: UserUI? by mutableStateOf(null)
        private set

    fun getUser() = run {
        viewModelScope.launch {
            user = userUseCase.user()?.run { UserUI(this) }
        }
    }
}