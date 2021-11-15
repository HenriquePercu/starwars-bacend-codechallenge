package com.starwars.converter

import com.starwars.model.PlanetRequest
import com.starwars.repository.Planet
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper

@Mapper
interface PlanetConverter {

    fun convertRequestToRepository(planetRequest: PlanetRequest) : Planet

    @InheritInverseConfiguration
    fun convertToRequest(planet: Planet ) : PlanetRequest

}