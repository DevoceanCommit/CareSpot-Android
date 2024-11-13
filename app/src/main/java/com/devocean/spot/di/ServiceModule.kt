package com.devocean.spot.di

import com.devocean.data.service.ChatService
import com.devocean.spot.di.qualifier.JWT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideChatService(@JWT retrofit: Retrofit): ChatService =
        retrofit.create(ChatService::class.java)

}