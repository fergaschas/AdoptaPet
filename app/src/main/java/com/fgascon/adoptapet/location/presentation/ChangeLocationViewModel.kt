package com.fgascon.adoptapet.location.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.location.domain.LocationRepository
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChangeLocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ChangeLocationState())
    val state: StateFlow<ChangeLocationState> = _state

    init {
        getUserLocation()
    }

    private fun getUserLocation() {
        viewModelScope.launch {
            locationRepository.getUserLocation().collect { location ->
                _state.update {
                    ChangeLocationState(
                        location = location,
                        isLocationLoaded = true
                    )
                }
            }
        }
    }

    fun saveLocation() {
        viewModelScope.launch {
            locationRepository.changeLocation(state.value.location)
        }
    }

    fun changeLocation(location: LatLng) {
        _state.update {
            it.copy(location = location)
        }
    }

}

data class ChangeLocationState(
    val location: LatLng = LatLng(0.0, 0.0),
    val isLocationLoaded: Boolean = false
)

