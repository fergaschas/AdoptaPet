package com.fgascon.adoptapet.location.domain

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun getUserLocation(): Flow<LatLng>
    suspend fun changeLocation(location: LatLng)
    suspend fun getLocationFrom(location: LatLng): UserLocation
}