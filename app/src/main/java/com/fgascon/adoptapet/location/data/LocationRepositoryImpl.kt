package com.fgascon.adoptapet.location.data

import com.fgascon.adoptapet.core.data.DataStoreManager
import com.fgascon.adoptapet.location.domain.LocationRepository
import com.fgascon.adoptapet.location.domain.UserLocation
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val dataStore: DataStoreManager,
    private val geocoderService: GeocoderService
): LocationRepository {

    override suspend fun changeLocation(location: LatLng) {
        dataStore.changeLocation(location)
    }

    override suspend fun getLocationFrom(location: LatLng) : UserLocation{
        return geocoderService.getAddressFromLocation(location)
    }

    override suspend fun getUserLocation() : Flow<LatLng> {
        return dataStore.getLatLng()
    }
}