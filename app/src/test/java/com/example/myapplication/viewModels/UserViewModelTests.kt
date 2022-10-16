package com.example.myapplication.viewModels

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myapplication.repo.UserRepo
import com.example.myapplication.repo.network.Endpoints
import com.example.myapplication.repo.network.Service
import com.example.myapplication.useCases.UserUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTests {

    @get:Rule
    val rule = InstantTaskExecutorRule()


    private val dispatcher = StandardTestDispatcher()

    private lateinit var endpoints: Endpoints
    private lateinit var service: Service
    private lateinit var userRepo: UserRepo

    @MockK
    private lateinit var userUseCase: UserUseCase
    private lateinit var userViewModel: UserViewModel


    @Before
    fun setup() {
        /*endpoints = mockkClass(Endpoints::class)
        service = Service(endpoints)
        userRepo = UserRepo(service)
        userUseCase = UserUseCase(userRepo)*/

        MockKAnnotations.init(this)
        userViewModel = UserViewModel(userUseCase)
    }

    //todo, look at using: https://github.com/square/okhttp/tree/master/mockwebserver
    /*@Test
    fun `refresh user`() = runTest {
        userViewModel.fetchUser()
        assertEquals()
    }*/
}