package com.fgascon.adoptapet.location.data

import android.content.Context
import android.location.Geocoder
import com.fgascon.adoptapet.location.domain.UserLocation
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject

class GeocoderService @Inject constructor(
    private val context: Context
) {

    suspend fun getAddressFromLocation(location: LatLng): UserLocation {
        return suspendCancellableCoroutine { cancellableContinuation ->
            Geocoder(context).getFromLocation(
                location.latitude, location.longitude, 1
            ) { list ->
                list.firstOrNull()?.let { address ->
                    cancellableContinuation.resumeWith(
                        Result.success(
                            UserLocation(
                                latitude = location.latitude,
                                longitude = location.longitude,
                                address = address.getAddressLine(0),
                                city = address.locality,
                                country = address.countryName
                            )
                        )
                    )
                }
            }
        }

    }
}