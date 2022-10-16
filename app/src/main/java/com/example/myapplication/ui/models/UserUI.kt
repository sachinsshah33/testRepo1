package com.example.myapplication.ui.models

import android.os.Parcelable
import com.example.myapplication.Constants
import com.example.myapplication.repo.local.models.UserLocal
import com.example.myapplication.ui.extensions.toPercentageOutOf1
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserUI(
    val subscription_miles_left: Float,
    val last_energy_level: Float
) : Parcelable {
    constructor(model: UserLocal) : this(
        subscription_miles_left = model.bookings.firstOrNull()?.subscription_miles_left?.toPercentageOutOf1(Constants.subscriptionMilesLeftMax)?:0f,
        last_energy_level = model.bookings.firstOrNull()?.car?.last_energy_level?.toPercentageOutOf1(Constants.lastEnergyLevelMax)?:0f
    )
}