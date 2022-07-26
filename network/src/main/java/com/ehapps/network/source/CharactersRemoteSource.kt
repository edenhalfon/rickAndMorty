package com.ehapps.network.source

import com.ehapps.network.ApiResponse
import com.ehapps.network.response.CharactersResponse
import com.ehapps.network.services.CharactersService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CharactersRemoteSource(private val charactersService: CharactersService) {

    fun getAllCharacters(): Flow<ApiResponse<CharactersResponse>> {
        return flow {
            emit(
                //TODO move the conversion to retrofit converter
                charactersService.getAllCharacters().let {
                    if (it == null) {
                        ApiResponse.Empty
                    } else {
                        ApiResponse.Success(it)
                    }
                }
            )

        }.flowOn(Dispatchers.IO)
    }
}