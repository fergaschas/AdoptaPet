package com.fgascon.adoptapet.pet.domain

import com.fgascon.adoptapet.pet.data.PetRepositoryImpl
import kotlinx.coroutines.flow.Flow

class GetPetsUseCase (
    private val petRepository: PetRepository = PetRepositoryImpl()
){
    suspend fun getPets() : Flow<List<Pet>> {
        return petRepository.getPets()
    }
}
