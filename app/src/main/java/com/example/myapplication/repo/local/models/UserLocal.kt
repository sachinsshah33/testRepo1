package com.example.myapplication.repo.local.models

import android.os.Parcelable
import com.example.myapplication.repo.network.models.UserResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserLocal(
    val bookings: List<Booking>,
) : Parcelable {
    constructor(model: UserResponse) : this(
        bookings = model.bookings.map { Booking(it) }
    )
}

@Parcelize
data class Booking(
    val car: Car,
    val subscription_miles_left: Int
) : Parcelable {
    constructor(model: com.example.myapplication.repo.network.models.Booking) : this(
        car = Car(model.car),
        subscription_miles_left = model.subscription_miles_left.toInt()
    )
}

@Parcelize
data class Car(
    val last_energy_level: Int
) : Parcelable {
    constructor(model: com.example.myapplication.repo.network.models.Car) : this(
        last_energy_level = model.last_energy_level.toInt()
    )
}