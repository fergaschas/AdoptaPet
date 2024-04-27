package com.fgascon.adoptapet.location.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditLocationAlt
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerComposable
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ChangeLocationScreen(
    state: State<ChangeLocationState>,
    onChangeLocation: (LatLng) -> Unit,
    onSaveLocation: () -> Unit,
) {

    if (!state.value.isLocationLoaded) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            LinearProgressIndicator()
        }
    }

    if (state.value.isLocationLoaded) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(state.value.location, 10f)
        }
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        onSaveLocation()
                    },
                    content = {
                        Icon(
                            imageVector = Icons.Filled.EditLocationAlt,
                            contentDescription = null
                        )
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.Center,
            content = { paddingValues ->
                GoogleMap(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                    onMapClick = {
                        onChangeLocation(it)
                    },
                    uiSettings = MapUiSettings(zoomControlsEnabled = false),
                    content = {
                        MarkerComposable(
                            state = MarkerState(state.value.location),
                            content = {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}