package com.fgascon.adoptapet.location.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {

    suspend fun getUserLocation(): Flow<UserLocation> {
        return locationRepository.getUserLocation().map { location ->
            locationRepository.getLocationFrom(location)
        }
    }
}
