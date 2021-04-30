package com.example.plugins

import com.example.homeRoute
import com.example.messageRoute
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
       homeRoute()
        messageRoute()
    }
}
