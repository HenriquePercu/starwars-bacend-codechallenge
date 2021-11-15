package com.starwars.service

import com.starwars.model.PlanetRequest


interface PlanetService {

    fun create(planet: PlanetRequest)

}