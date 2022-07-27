package com.ehapps.network.services

import com.ehapps.network.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {
    @GET("/api/character")
    suspend fun getAllCharacters(@Query("page") page: Int = 1): CharactersResponse?
}