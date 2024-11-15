package com.devocean.spot.di

import com.devocean.data.repositoryimpl.ChatRepositoryImpl
import com.devocean.data.repositoryimpl.HomeRepositoryImpl
import com.devocean.domain.repository.ChatRepository
import com.devocean.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindChatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository


    @Binds
    @Singleton
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

}