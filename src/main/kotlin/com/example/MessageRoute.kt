package com.example

import com.slack.api.Slack
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.messageRoute() {

        post("/message") {
            val payload = call.receive<String>()
            call.respond(HttpStatusCode.OK,payload)
            val token = System.getenv("SLACK_TOKEN")
            val slack = Slack.getInstance()
            val response = slack.methods(token).chatPostMessage {
                it.channel("#bot")
                    .text("God morgen til deg og!:")
            }
        }


    }
//    post("/message") {
////        val payload:
////        res.sendStatus(200)
//
//        val token = System.getenv("SLACK_TOKEN")
//        val slack = Slack.getInstance()
//        val response = slack.methods(token).chatPostMessage {
//        it.channel("#bot")
//            .text("God morgen til deg og!:")
//    }
//        call.respondText("Response is: $response")
//    }
//}