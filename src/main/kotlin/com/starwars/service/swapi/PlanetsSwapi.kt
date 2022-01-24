package com.starwars.service.swapi

data class PlanetsSwapi(
    val count: Int ?= null,
    val next: Boolean,
    val previous: Boolean,
    val results: List<PlanetSwapi>
){}