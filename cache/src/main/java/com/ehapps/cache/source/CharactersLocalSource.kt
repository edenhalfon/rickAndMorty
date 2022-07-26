package com.ehapps.cache.source

import com.ehapps.cache.dao.CharactersDao
import com.ehapps.cache.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

class CharactersLocalSource(private val charactersDao: CharactersDao) {
    fun getAllCharacters(): Flow<List<CharacterEntity>> = charactersDao.getAllCharacters()

    fun insertAllCharacters(characters: List<CharacterEntity>) {
         charactersDao.insertAllCharacters(characters)
    }
}