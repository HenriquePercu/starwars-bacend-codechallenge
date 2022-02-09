package com.starwars.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [(PlanetNotFoundException::class)])
    fun handleNotExistsPlanet(exception: PlanetNotFoundException): ResponseEntity<ErrorDetailResponse> {
        return ResponseEntity(
            ErrorDetailResponse(
                LocalDateTime.now(),
                exception.message
            ), HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler(value = [(IllegalPlanetNameException::class)])
    fun handleIllegalPlanetNameException(exception: IllegalPlanetNameException): ResponseEntity<ErrorDetailResponse> {
        return ResponseEntity(
            ErrorDetailResponse(
                LocalDateTime.now(),
                exception.message
            ), HttpStatus.UNPROCESSABLE_ENTITY
        )
    }

    @ExceptionHandler(value = [(Exception::class)])
    fun handleIllegalPlanetNameException(exception: Exception): ResponseEntity<ErrorDetailResponse> {
        return ResponseEntity(
            ErrorDetailResponse(
                LocalDateTime.now(),
                "Ops! Ocorreu um erro em nosso sistema"
            ), HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

}