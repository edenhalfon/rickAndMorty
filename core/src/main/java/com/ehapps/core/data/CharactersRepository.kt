package com.ehapps.core.data

import com.ehapps.cache.source.CharactersLocalSource
import com.ehapps.core.domain.model.ShowCharacter
import com.ehapps.core.domain.repository.ICharactersRepository
import com.ehapps.core.utils.CharactersDataMapper
import com.ehapps.network.ApiResponse
import com.ehapps.network.response.CharactersResponse
import com.ehapps.network.source.CharactersRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class CharactersRepository(
    private val charactersRemoteSource: CharactersRemoteSource,
    private val charactersLocalSource: CharactersLocalSource
) : ICharactersRepository {

    override fun getAllCharacters(page: Int): Flow<Resource<List<ShowCharacter>>> = object :
        NetworkBoundResource<List<ShowCharacter>, CharactersResponse>() {
        override fun loadFromDB(): Flow<List<ShowCharacter>> {
            return charactersLocalSource.getAllCharacters().map {
                CharactersDataMapper.mapEntitiesToDomain(it)
            }
        }

        override fun shouldFetch(data: List<ShowCharacter>?): Boolean {
            return true
        }

        override suspend fun createCall(): Flow<ApiResponse<CharactersResponse>> {
            return charactersRemoteSource.getAllCharacters(page)
        }

        override suspend fun saveCallResult(data: CharactersResponse) {
            withContext(Dispatchers.Default) {
                charactersLocalSource.insertAllCharacters(
                    CharactersDataMapper.mapResponseToEntity(data)
                )
            }
        }

    }.asFlow()

    companion object {
        const val TAG = "CharactersRepository"
    }
}