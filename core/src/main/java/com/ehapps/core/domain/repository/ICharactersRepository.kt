package com.ehapps.core.domain.repository

import com.ehapps.core.data.Resource
import com.ehapps.core.domain.model.ShowCharacter
import kotlinx.coroutines.flow.Flow

interface ICharactersRepository {

    fun getAllCharacters(page: Int = 1): Flow<Resource<List<ShowCharacter>>>
}