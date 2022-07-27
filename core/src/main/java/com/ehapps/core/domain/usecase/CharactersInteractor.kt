package com.ehapps.core.domain.usecase

import com.ehapps.core.data.Resource
import com.ehapps.core.domain.model.ShowCharacter
import com.ehapps.core.domain.repository.ICharactersRepository
import kotlinx.coroutines.flow.Flow

class CharactersInteractor(private val charactersRepository: ICharactersRepository): CharactersUseCase {
    override fun getAllCharacters(page: Int): Flow<Resource<List<ShowCharacter>>> {
        return charactersRepository.getAllCharacters(page)
    }
}