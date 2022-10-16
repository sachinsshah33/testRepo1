package com.example.myapplication.ui.extensions

fun Number.toPercentageOutOf1(total: Number = 100): Float {
    val number = if (this is Float) this else this.toFloat()
    val outOff = if (total is Float) total else total.toFloat()
    return number / outOff
}