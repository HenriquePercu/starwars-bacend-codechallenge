package com.starwars.service

import com.starwars.model.Planet
import com.starwars.model.PlanetRequest


interface PlanetService {

    fun create(planet: Planet): Planet

    fun delete(id: Int)

    fun listAll(): List<Planet>

    fun findByName(name: String): Planet

    fun findById(id: Int): Planet
}