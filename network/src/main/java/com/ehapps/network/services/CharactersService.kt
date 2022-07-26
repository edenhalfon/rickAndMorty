package com.ehapps.network.services

import com.ehapps.network.response.CharactersResponse
import retrofit2.http.GET

interface CharactersService {
    @GET("/api/character")
    suspend fun getAllCharacters(): CharactersResponse?
}