package com.starwars.service

import com.starwars.converter.PlanetConverter
import com.starwars.model.PlanetRequest
import com.starwars.repository.PlanetRepository
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class PlanetServiceImpl(
    private val planetRepository: PlanetRepository
) : PlanetService {

    override fun create(planet: PlanetRequest) {
        val converter = Mappers.getMapper(PlanetConverter::class.java)

        planetRepository.save(converter.convertRequestToRepository(planet))
    }
}