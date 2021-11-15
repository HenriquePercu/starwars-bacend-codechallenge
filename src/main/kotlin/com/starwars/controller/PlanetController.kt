package com.starwars.controller

import com.starwars.converter.PlanetConverter
import com.starwars.model.PlanetRequest
import com.starwars.service.PlanetService
import org.mapstruct.factory.Mappers
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("planets")
class PlanetController(
    private val planetService: PlanetService

) {
    // TODO encapsula response em Status Code HTTP
    // TODO criar classe pra interceptar excecoes

    @PostMapping("/")
    fun createPlanet(@RequestBody planet: PlanetRequest) {
        planetService.create(planet)
    }

    @GetMapping("/")
    fun getPlanets(): List<PlanetRequest> {
        return arrayListOf(PlanetRequest("", "", "", ""))
    }

    @GetMapping("/{planetName}")
    fun getPlanetsByName(@PathVariable planetName: String): PlanetRequest {
        return PlanetRequest("", "", "", "")
    }

    @GetMapping("/{planetId}")
    fun getPlanetsByName(@PathVariable planetId: Int): PlanetRequest {
        return PlanetRequest("", "", "", "")
    }

    @DeleteMapping("/{planetId}")
    fun deletePlanetById(@PathVariable planetId: Int) {

    }

}