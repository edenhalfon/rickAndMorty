package com.ehapps.core.domain.usecase

import com.ehapps.core.data.Resource
import com.ehapps.core.domain.model.ShowCharacter
import kotlinx.coroutines.flow.Flow

interface CharactersUseCase {
    fun getAllCharacters(): Flow<Resource<List<ShowCharacter>>>
}