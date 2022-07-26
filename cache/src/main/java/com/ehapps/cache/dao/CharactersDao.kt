package com.ehapps.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ehapps.cache.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Query("SELECT * FROM character LIMIT 15")
    fun getAllCharacters(): Flow<List<CharacterEntity>>

    @Insert
    fun insertAllCharacters(characters: List<CharacterEntity>)
}