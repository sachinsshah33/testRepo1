package com.example.myapplication.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.ui.models.UserUI
import com.example.myapplication.useCases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userUseCase: UserUseCase //IUserUseCase
) : ViewModel() {

    private var user: UserUI? by mutableStateOf(null)
    val subscriptionMilesLeft get() = user?.subscription_miles_left?:0
    val lastEnergyLevel get() = user?.last_energy_level?:0

    fun fetchUser() = run {
        user = null
        viewModelScope.launch {
            delay(500) // this is just so circular progress animation has time to animate, todo think of a better way for this
            user = userUseCase.user()?.run { UserUI(this) }

            //todo, add some loading logic here, i.e. show loading spinner or toast if network call failed
        }
    }
}