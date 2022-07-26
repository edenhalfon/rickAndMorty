package com.ehapps.core.di

import com.ehapps.core.domain.usecase.CharactersInteractor
import com.ehapps.core.domain.usecase.CharactersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<CharactersUseCase> { CharactersInteractor(get()) }
}