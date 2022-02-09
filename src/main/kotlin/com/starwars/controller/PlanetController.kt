package com.starwars.controller

import com.starwars.model.PlanetRequest
import com.starwars.model.toPlanet
import com.starwars.model.toPlanetRequest
import com.starwars.service.PlanetService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("planets")
class PlanetController(
    private val planetService: PlanetService

) {
    // Tratamento de exceção para deleção

    @PostMapping("/")
    fun createPlanet(@RequestBody planet: PlanetRequest): ResponseEntity<PlanetRequest> {
        return ResponseEntity(planetService.create(planet.toPlanet()).toPlanetRequest(), HttpStatus.CREATED)
    }

    @GetMapping("/")
    fun getPlanets(): ResponseEntity<List<PlanetRequest>> {
        return ResponseEntity(planetService.listAll().map { it.toPlanetRequest() }, HttpStatus.OK)
    }

    @GetMapping("")
    fun getPlanetsByName(@RequestParam planetName: String): ResponseEntity<PlanetRequest> {
        return ResponseEntity(planetService.findByName(planetName).toPlanetRequest(), HttpStatus.OK)
    }

    @GetMapping("/{planetId}")
    fun getPlanetsById(@PathVariable planetId: Int): ResponseEntity<PlanetRequest> {
        return ResponseEntity(planetService.findById(planetId).toPlanetRequest(), HttpStatus.OK)
    }

    @DeleteMapping("/{planetId}")
    fun deletePlanetById(@PathVariable planetId: Int): ResponseEntity<HttpStatus> {
        planetService.delete(planetId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}