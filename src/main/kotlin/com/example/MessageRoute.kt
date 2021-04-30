package com.example

import com.slack.api.Slack
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import jdk.nashorn.internal.objects.NativeFunction.function

fun Routing.messageRoute() {

        post("/message") {
            val payload = call.request

            call.respond(200)
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
}