package com.fgascon.adoptapet.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    suspend fun changeLocation(location: LatLng) {
        dataStore.edit {preferences ->
            preferences[PreferenceKeys.LATITUDE] = location.latitude
            preferences[PreferenceKeys.LONGITUDE] = location.longitude
        }
    }

    fun getLatLng() : Flow<LatLng> {
        return dataStore.data.map {
            val latitude = it[PreferenceKeys.LATITUDE] ?: 0.0
            val longitude = it[PreferenceKeys.LONGITUDE] ?: 0.0
            LatLng(latitude, longitude)
        }
    }

}