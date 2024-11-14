package com.devocean.spot.di

import com.devocean.data.datasource.ChatDataSource
import com.devocean.data.datasource.HomeDataSource
import com.devocean.data.datasourceimpl.ChatDataSourceImpl
import com.devocean.data.datasourceimpl.HomeDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindChatDataSource(chatDataSourceImpl: ChatDataSourceImpl): ChatDataSource


    @Binds
    @Singleton
    abstract fun bindHomeDataSource(homeDataSourceImpl: HomeDataSourceImpl): HomeDataSource

}