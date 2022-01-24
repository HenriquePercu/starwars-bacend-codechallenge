package com.starwars.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PlanetRepository : JpaRepository<PlanetModel, Int> {

    fun findByName(name: String): List<PlanetModel>

}