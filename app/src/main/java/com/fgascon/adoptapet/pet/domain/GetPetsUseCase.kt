package com.fgascon.adoptapet.pet.domain

import kotlinx.coroutines.flow.Flow

class GetPetsUseCase (
    private val petRepository: PetRepository
){
    suspend fun getPets() : Flow<List<Pet>> {
        return petRepository.getPets()
    }
}
