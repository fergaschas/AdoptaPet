package com.fgascon.adoptapet.location.domain

data class UserLocation(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val address: String = "",
    val city: String = "",
    val country: String = "",
)