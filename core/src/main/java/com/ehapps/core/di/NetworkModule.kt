package com.ehapps.core.di

import com.ehapps.network.manager.NetworkManager
import com.ehapps.network.services.CharactersService
import com.ehapps.network.source.CharactersRemoteSource
import org.koin.dsl.module

val networkModule = module {
    single { NetworkManager.retrofit.create(CharactersService::class.java) }
    single { CharactersRemoteSource(get()) }
}