package controller

import model.Planet
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("planets")
class PlanetController {

    // TODO encapsulta response em Status Code HTTP
    // TODO criar classe pra interceptar excecoes

    @PostMapping("/")
    fun createPlanet(@RequestBody planet: Planet){

    }

    @GetMapping("/")
    fun getPlanets() : List<Planet>{
        return arrayListOf(Planet("","","",""))
    }

    @GetMapping("/{planetName}")
    fun getPlanetsByName(@PathVariable planetName: String) : Planet{
        return Planet("","","","")
    }

    @GetMapping("/{planetId}")
    fun getPlanetsByName(@PathVariable planetId: Int) : Planet{
        return Planet("","","","")
    }

    @DeleteMapping("/{planetId}")
    fun deletePlanetById(@PathVariable planetId: Int){

    }

}