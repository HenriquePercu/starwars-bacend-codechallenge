package com.starwars.model

import com.starwars.repository.PlanetModel

data class Planet(
    val id: Int ?= null,
    val name: String,
    val weather: String,
    val terrain: String,
    val movieApparitions: String ?= null
){}

fun Planet.toPlanetModel() = PlanetModel(
    name = name,
    weather = weather,
    terrain = terrain,
)

fun Planet.toPlanetRequest() = PlanetRequest(
    id = id,
    name = name,
    weather = weather,
    terrain = terrain,
    movieApparitions = movieApparitions
)
