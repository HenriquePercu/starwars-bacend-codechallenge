package com.starwars.model

data class PlanetRequest(
    val name: String,
    val weather: String,
    val terrain: String,
    val movieApparitions: String ?= null
) {
    constructor() : this("","","","")
}