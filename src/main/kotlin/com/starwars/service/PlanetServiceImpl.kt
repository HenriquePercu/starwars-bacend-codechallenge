package com.starwars.service

import com.starwars.client.SwapiClient
import com.starwars.exception.IllegalPlanetNameException
import com.starwars.exception.PlanetNotFoundException
import com.starwars.model.Planet
import com.starwars.model.toPlanetModel
import com.starwars.repository.PlanetRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.NoSuchElementException
import java.util.function.Consumer

@Service
class PlanetServiceImpl(
    private val planetRepository: PlanetRepository,
    private val swapiClient: SwapiClient
) : PlanetService {

    override fun create(planet: Planet): Planet {
        val planetModel = planetRepository.save(planet.toPlanetModel())

        val quantityFilms =
            swapiClient.getPlanetByName(planetModel.name).takeIf { planetsSwapi -> planetsSwapi.count > 0 }
                ?: throw IllegalPlanetNameException("Não foi encontrado um planeta com este nome")

        return Planet(
            planetModel.id_planet,
            planetModel.name,
            planetModel.weather,
            planetModel.terrain,
            quantityFilms.results[0].films.size
        )
    }

    override fun listAll(): List<Planet> {
        return planetRepository.findAll().map {
            Planet(
                it.id_planet,
                it.name,
                it.weather,
                it.terrain,
                swapiClient.getPlanetByName(it.name).results[0].films.size
            )
        }
    }

    override fun findByName(name: String): Planet {
        return planetRepository.findByName(name).map {
            Planet(
                it.id_planet,
                it.name,
                it.weather,
                it.terrain,
                swapiClient.getPlanetByName(it.name).results[0].films.size
            )
        }.takeIf { it.isNotEmpty() }?.first()
            ?: throw PlanetNotFoundException("Planeta não encontrado com este nome em nosso banco de dados")
    }

    override fun delete(id: Int) {
        runCatching {
            planetRepository.deleteById(id)
        }.onFailure { exception ->
            when (exception) {
                is EmptyResultDataAccessException -> {
                    throw PlanetNotFoundException("Planeta não encontrado com este nome em nosso banco de dados")
                }
                else -> throw Exception()
            }
        }

    }

    override fun findById(id: Int): Planet {
        return planetRepository.findById(id).map {
            Planet(
                it.id_planet,
                it.name,
                it.weather,
                it.terrain,
                swapiClient.getPlanetByName(it.name).results[0].films.size
            )
        }.orElseThrow { PlanetNotFoundException("Planeta não encontrado") }
    }
}