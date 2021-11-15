package com.starwars.repository

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "planet")
data class Planet(
    @Id @GeneratedValue var id_planet: Int? = null,
    var name: String,
    var weather: String,
    var terrain: String
){
    constructor() : this(0,"","","")
}