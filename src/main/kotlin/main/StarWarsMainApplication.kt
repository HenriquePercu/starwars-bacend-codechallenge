package main

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class StarWarsMainApplication

    fun main(args: Array<String>){
        runApplication<StarWarsMainApplication>(*args)
    }



