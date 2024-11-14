package com.devocean.spot.di

import com.devocean.core.extension.isJsonArray
import com.devocean.core.extension.isJsonObject
import com.devocean.spot.BuildConfig.BASE_URL
import com.devocean.spot.di.qualifier.JWT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val APPLICATION_JSON = "application/json"

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    @Provides
    @Singleton
    fun provideJsonConverter(json: Json): Converter.Factory =
        json.asConverterFactory(APPLICATION_JSON.toMediaType())

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): Interceptor = HttpLoggingInterceptor { message ->
        when {
            message.isJsonObject() ->
                Timber.tag("okhttp").d(JSONObject(message).toString(4))

            message.isJsonArray() ->{
                val jsonArray = org.json.JSONArray(message)
                Timber.tag("okhttp").d(jsonArray.toString(4))
            }

            else -> {
                Timber.tag("okhttp").d("CONNECTION INFO -> $message")
            }
        }
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @JWT
    @Provides
    fun provideAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer <token>")
                .build()
            chain.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    @JWT
    fun provideJWTOkHttpClient(
        loggingInterceptor: Interceptor,
        @JWT authInterceptor: Interceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    @JWT
    fun provideJWTRetrofit(
        @JWT client: OkHttpClient,
        factory: Converter.Factory,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(factory)
        .build()
}