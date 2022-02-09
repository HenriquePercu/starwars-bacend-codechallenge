package com.starwars.service.swapi

data class PlanetsSwapi(
    val count: Int,
    val next: Boolean,
    val previous: Boolean,
    val results: List<PlanetSwapi>
){}