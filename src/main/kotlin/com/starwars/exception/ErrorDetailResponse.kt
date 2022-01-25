package com.starwars.exception

import java.time.LocalDateTime

data class ErrorDetailResponse(
    val timestamp: LocalDateTime,
    val details: String?
)