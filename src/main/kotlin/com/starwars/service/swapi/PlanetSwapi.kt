package com.starwars.service.swapi

import com.fasterxml.jackson.annotation.JsonProperty

data class PlanetSwapi(
    val name: String,
    @JsonProperty("rotation_period") val rotationPeriod: String,
    @JsonProperty("orbital_period") val orbitalPeriod: String,
    val diameter: String? = null,
    val films: List<String>
)