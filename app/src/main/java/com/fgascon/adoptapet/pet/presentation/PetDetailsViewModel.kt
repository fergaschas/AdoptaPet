package com.fgascon.adoptapet.pet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.domain.emptyPet
import com.fgascon.adoptapet.pet.domain.GetPetByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PetDetailsViewModel(
    private val getPetUseCase: GetPetByIdUseCase,
    id: String
) : ViewModel() {
    private val _state: MutableStateFlow<Pet> = MutableStateFlow(emptyPet())
    val state: StateFlow<Pet> = _state

    init {
        getPetById(id)
    }

    private fun getPetById(id: String) {
        viewModelScope.launch {
            getPetUseCase.getPetById(id).collect { pet ->
                _state.value = pet
            }
        }
    }
}
