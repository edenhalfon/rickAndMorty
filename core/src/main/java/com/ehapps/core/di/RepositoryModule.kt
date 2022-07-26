package com.ehapps.core.di

import com.ehapps.core.data.CharactersRepository
import com.ehapps.core.domain.repository.ICharactersRepository
import org.koin.dsl.module

val repoModule = module {
    single<ICharactersRepository> {
        CharactersRepository(
            get(),
            get()
        )
    }
}