package com.example.myapplication.repo.network.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserResponse(
    val bookings: List<Booking>,
) : Parcelable

@Parcelize
data class Booking(
    val car: Car,
    val subscription_miles_left: String
) : Parcelable

@Parcelize
data class Car(
    val last_energy_level: String
) : Parcelable
