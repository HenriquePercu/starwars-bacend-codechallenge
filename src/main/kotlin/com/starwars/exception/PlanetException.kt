package com.starwars.exception

import java.lang.RuntimeException

class PlanetNotFoundException(message: String) : RuntimeException(message)

class IllegalPlanetNameException(message: String) : RuntimeException(message)