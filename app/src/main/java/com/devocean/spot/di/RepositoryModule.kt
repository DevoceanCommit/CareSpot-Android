package com.devocean.spot.di

import com.devocean.data.repositoryimpl.ChatRepositoryImpl
import com.devocean.domain.repository.ChatRepository
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

}