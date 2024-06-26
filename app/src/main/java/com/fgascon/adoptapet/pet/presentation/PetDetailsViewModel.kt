package com.fgascon.adoptapet.pet.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.pet.domain.GetPetByIdUseCase
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.domain.emptyPet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
    private val getPetUseCase: GetPetByIdUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state: MutableStateFlow<Pet> = MutableStateFlow(emptyPet())
    val state: StateFlow<Pet> = _state

    init {
        val id = savedStateHandle.get<String>("petId") ?: ""
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
