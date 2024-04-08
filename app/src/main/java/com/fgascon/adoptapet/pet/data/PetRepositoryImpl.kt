package com.fgascon.adoptapet.pet.data

import com.fgascon.adoptapet.pet.domain.Pet
import com.fgascon.adoptapet.pet.domain.PetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PetRepositoryImpl(
    private val firebasePetApi: FirebasePetApi = FirebasePetApi()
) : PetRepository {
    override suspend fun getPets(): Flow<List<Pet>> {
        return firebasePetApi.getPets().map { list ->
            list.map { pet ->
                pet.toDomain()
            }
        }
    }

    override suspend fun getPetById(id: String): Flow<Pet> {
        return firebasePetApi.getPetById(id).map { pet ->
            pet.toDomain()
        }
    }
}

