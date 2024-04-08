package com.fgascon.adoptapet.pet.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.domain.GetPetsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PetListViewModel(
    private val getPetsUseCase: GetPetsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<List<Pet>> = MutableStateFlow(emptyList())
    val state: StateFlow<List<Pet>> = _state

    init {
        getPets()
    }

    private fun getPets() {
        viewModelScope.launch {
            getPetsUseCase.getPets().collect {
                _state.value = it
            }

        }
    }

}
