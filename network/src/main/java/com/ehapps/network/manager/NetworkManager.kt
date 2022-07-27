package com.ehapps.network.manager

import com.ehapps.network.util.Consts
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object NetworkManager {

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private val jsonSerializer = Json {
        encodeDefaults = true
        ignoreUnknownKeys = true
        prettyPrint = true
        coerceInputValues = true
    }

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Consts.Network.BASE_URL)
            .addConverterFactory(jsonSerializer.asConverterFactory("application/json".toMediaTypeOrNull()!!))
            .client(client)
            .build()
    }

}