package com.ehapps.core.utils

import com.ehapps.cache.entity.CharacterEntity
import com.ehapps.core.domain.model.ShowCharacter
import com.ehapps.core.domain.model.Status
import com.ehapps.network.response.CharactersResponse

object CharactersDataMapper {

    fun mapEntitiesToDomain(input: List<CharacterEntity>) = input.map {
        ShowCharacter(
            it.id,
            it.name,
            Status.valueOf(it.status),
            it.species,
            it.type,
            it.gender,
            it.image,
            it.url
        )
    }

    fun mapResponseToEntity(input: CharactersResponse) = input.results.map {
        CharacterEntity(
            it.id,
            it.name,
            it.status.toString(),
            it.species,
            it.type,
            it.gender,
            it.image,
            it.url
        )
    }

}