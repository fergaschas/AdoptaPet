package com.fgascon.adoptapet.pet.domain

import kotlinx.coroutines.flow.Flow

interface PetRepository {
    suspend fun getPets(): Flow<List<Pet>>
    suspend fun getPetById(id: String): Flow<Pet>
}
