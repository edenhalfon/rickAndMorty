package com.ehapps.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ehapps.cache.dao.CharactersDao
import com.ehapps.cache.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun charactersDao(): CharactersDao
}