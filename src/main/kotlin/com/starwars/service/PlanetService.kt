package com.starwars.service

import com.starwars.model.Planet
import com.starwars.model.PlanetRequest


interface PlanetService {

    fun create(planet: Planet): Planet

    fun listAll(): List<Planet>

}