package com.starwars
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients


@SpringBootApplication
@EnableFeignClients
open class StarWarsMainApplication

    fun main(args: Array<String>){
        runApplication<StarWarsMainApplication>(*args)
    }



