package com.fgascon.adoptapet.core.data

import androidx.datastore.preferences.core.doublePreferencesKey

object PreferenceKeys {
    val LATITUDE = doublePreferencesKey("latitude")
    val LONGITUDE = doublePreferencesKey("longitude")
}