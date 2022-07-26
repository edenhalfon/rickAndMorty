package com.ehapps.core.data

import com.ehapps.cache.source.CharactersLocalSource
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

    override fun getAllCharacters(): Flow<Resource<List<com.ehapps.core.domain.model.ShowCharacter>>> =
        object :
            NetworkBoundResource<List<com.ehapps.core.domain.model.ShowCharacter>, CharactersResponse>() {
            override fun loadFromDB(): Flow<List<com.ehapps.core.domain.model.ShowCharacter>> {
                return charactersLocalSource.getAllCharacters().map {
                    CharactersDataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<com.ehapps.core.domain.model.ShowCharacter>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<CharactersResponse>> {
                return charactersRemoteSource.getAllCharacters()
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