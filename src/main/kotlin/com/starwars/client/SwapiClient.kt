package com.starwars.client

import com.starwars.service.swapi.PlanetsSwapi
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "SWAPI", url = "https://swapi.dev/api/")
interface SwapiClient {

    @GetMapping("planets/")
    fun getPlanetByName(@RequestParam(name = "search") planetName: String) : PlanetsSwapi

}