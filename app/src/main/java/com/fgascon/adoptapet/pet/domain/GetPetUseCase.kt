package com.fgascon.adoptapet.pet.domain

import kotlinx.coroutines.flow.Flow

class GetPetByIdUseCase(
    private val repository: PetRepository
) {
    suspend fun getPetById(id: String): Flow<Pet> {
        return repository.getPetById(id)
    }
}
