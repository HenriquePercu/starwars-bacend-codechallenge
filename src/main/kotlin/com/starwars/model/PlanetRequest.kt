package com.starwars.model

data class PlanetRequest(
    val id: Int ?= null,
    val name: String,
    val weather: String,
    val terrain: String,
    val movieApparitions: String? = null
){}

fun PlanetRequest.toPlanet() = Planet(
    name = name,
    weather = weather,
    terrain = terrain,
    movieApparitions = movieApparitions
)