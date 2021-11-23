package com.starwars.service

import com.starwars.model.Planet
import com.starwars.model.PlanetRequest
import com.starwars.model.toPlanetModel
import com.starwars.repository.PlanetRepository
import org.springframework.stereotype.Service

@Service
class PlanetServiceImpl(
    private val planetRepository: PlanetRepository
) : PlanetService {

    override fun create(planet: Planet): Planet {
        val planetModel = planetRepository.save(planet.toPlanetModel())

        return Planet(planetModel.id_planet, planetModel.name, planetModel.weather, planetModel.terrain, "")
    }
}