package com.starwars.controller

import com.starwars.model.PlanetRequest
import com.starwars.model.toPlanet
import com.starwars.model.toPlanetRequest
import com.starwars.service.PlanetService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("planets")
class PlanetController(
    private val planetService: PlanetService

) {
    // colocar para retornar o id da criaçaõ
    // TODO encapsula response em Status Code HTTP
    // TODO criar classe pra interceptar excecoes

    @PostMapping("/")
    fun createPlanet(@RequestBody planet: PlanetRequest): PlanetRequest {
        return planetService.create(planet.toPlanet()).toPlanetRequest()
    }

    @GetMapping("/")
    fun getPlanets(): List<PlanetRequest> {
        return arrayListOf(PlanetRequest(0,"", "", "", ""))
    }

    @GetMapping("/{planetName}")
    fun getPlanetsByName(@PathVariable planetName: String): PlanetRequest {
        return PlanetRequest(0,"", "", "", "")
    }

    @GetMapping("/{planetId}")
    fun getPlanetsByName(@PathVariable planetId: Int): PlanetRequest {
        return PlanetRequest(0,"", "", "", "")
    }

    @DeleteMapping("/{planetId}")
    fun deletePlanetById(@PathVariable planetId: Int) {

    }

}