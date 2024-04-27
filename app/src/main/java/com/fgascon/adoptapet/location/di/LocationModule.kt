package com.fgascon.adoptapet.location.di

import android.content.Context
import com.fgascon.adoptapet.core.data.DataStoreManager
import com.fgascon.adoptapet.location.data.GeocoderService
import com.fgascon.adoptapet.location.data.LocationRepositoryImpl
import com.fgascon.adoptapet.location.domain.GetUserLocationUseCase
import com.fgascon.adoptapet.location.domain.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Singleton
    @Provides
    fun provideGeocoderService(@ApplicationContext context: Context) = GeocoderService(context)
    @Singleton
    @Provides
    fun provideLocationRepository(
        dataStore: DataStoreManager,
        geocoderService: GeocoderService
    ): LocationRepositoryImpl = LocationRepositoryImpl(dataStore, geocoderService)

    @Singleton
    @Provides
    fun provideGetUserLocation(locationRepository: LocationRepository) =
        GetUserLocationUseCase(locationRepository)
}

@Module
@InstallIn(SingletonComponent::class)
interface LocationModuleBinds {
    @Binds
    fun provideLocationRepositoryImpl(locationRepositoryImpl: LocationRepositoryImpl): LocationRepository
}