package com.ehapps.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CharactersResponse(val results: List<Character>)

@Serializable
class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String
)

@Serializable
enum class Status {
    @SerialName("Alive") ALIVE,
    @SerialName("Dead") DEAD,
    @SerialName("unknown") UNKNOWN
}