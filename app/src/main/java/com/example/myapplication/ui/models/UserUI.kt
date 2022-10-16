package com.example.myapplication.ui.models

import android.os.Parcelable
import com.example.myapplication.repo.local.models.UserLocal
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserUI(
    val subscription_miles_left: Int?,
    val last_energy_level: Int?
) : Parcelable {
    constructor(model: UserLocal) : this(
        subscription_miles_left = model.bookings.firstOrNull()?.subscription_miles_left,
        last_energy_level = model.bookings.firstOrNull()?.car?.last_energy_level
    )
}