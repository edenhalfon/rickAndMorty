package com.ehapps.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
class CharacterEntity(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val image: String = "",
    val url: String = ""
)