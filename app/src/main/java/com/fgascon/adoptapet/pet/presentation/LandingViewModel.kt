package com.fgascon.adoptapet.pet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.location.domain.GetUserLocationUseCase
import com.fgascon.adoptapet.location.domain.UserLocation
import com.fgascon.adoptapet.pet.domain.GetPetsUseCase
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.presentation.SearchFilter.BY_CITY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val getPetsUseCase: GetPetsUseCase,
    private val getUserLocationUseCase: GetUserLocationUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<LandingState> = MutableStateFlow(LandingState())
    val state: StateFlow<LandingState> = _state

    init {
        getPets()
        getUserLocation()
    }

    private fun getUserLocation() {
        viewModelScope.launch {
            getUserLocationUseCase.getUserLocation().collect {
                _state.value = _state.value.copy(
                    userLocation = it
                )
            }
        }
    }

    private fun getPets() {
        viewModelScope.launch {
            getPetsUseCase.getPets().collect {
                _state.value = _state.value.copy(
                    pets = it
                )
            }
        }
    }

    fun setFilter(filter: SearchFilter) {
        _state.value = _state.value.copy(filter = filter)
        search(state.value.query)
    }

    fun search(query: String) {
        _state.value = _state.value.copy(query = query)
        if (query.isEmpty()) {
            _state.value = _state.value.copy(
                filteredPets = _state.value.pets
            )
            return
        }
        when (state.value.filter) {
            BY_CITY -> searchByCity(query)
        }
    }

    private fun searchByCity(query: String) {
        _state.value = _state.value.copy(
            filteredPets = _state.value.pets.filter {
                it.address.contains(query, ignoreCase = true)
            })
    }

}

data class LandingState(
    val pets: List<Pet> = emptyList(),
    val filteredPets: List<Pet> = emptyList(),
    val query: String = "",
    val filter: SearchFilter = BY_CITY,
    val userLocation: UserLocation = UserLocation()
)

enum class SearchFilter {
    BY_CITY,
}