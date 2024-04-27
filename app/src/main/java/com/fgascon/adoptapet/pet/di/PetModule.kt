package com.fgascon.adoptapet.pet.di

import com.fgascon.adoptapet.pet.data.FirebasePetApi
import com.fgascon.adoptapet.pet.data.PetRepositoryImpl
import com.fgascon.adoptapet.pet.domain.GetPetByIdUseCase
import com.fgascon.adoptapet.pet.domain.GetPetsUseCase
import com.fgascon.adoptapet.pet.domain.PetRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PetModule {

    @Singleton
    @Provides
    fun provideGetPetsUseCase(petRepository: PetRepository) = GetPetsUseCase(petRepository)

    @Singleton
    @Provides
    fun provideGetPetUseCase(petRepository: PetRepository) = GetPetByIdUseCase(petRepository)

    @Singleton
    @Provides
    fun providePetRepositoryImpl(firebasePetApi: FirebasePetApi): PetRepositoryImpl = PetRepositoryImpl(firebasePetApi)

    @Singleton
    @Provides
    fun provideFirebasePetApi(): FirebasePetApi = FirebasePetApi(FirebaseFirestore.getInstance())
}

@Module
@InstallIn(SingletonComponent::class)
interface PetModuleBinds {
    @Binds
    fun providePetRepository(petRepositoryImpl: PetRepositoryImpl): PetRepository
}