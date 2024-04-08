package com.fgascon.adoptapet.pet.domain

import com.fgascon.adoptapet.pet.data.PetRepositoryImpl
import kotlinx.coroutines.flow.Flow

class GetPetByIdUseCase(
    private val repository: PetRepository = PetRepositoryImpl()
) {
    suspend fun getPetById(id: String): Flow<Pet> {
        return repository.getPetById(id)
    }
}
