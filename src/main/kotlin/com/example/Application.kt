package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    val port = System.getenv("PORT").toIntOrNull() ?: 8080
    embeddedServer(Netty, port = port, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
