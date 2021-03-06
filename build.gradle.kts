val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val slack_version: String by project

plugins {
    application
    kotlin("jvm") version "1.4.32"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")
}
tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to "com.example.ApplicationKt",
            "Implementation-Version" to project.version))
    }
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
//    from(configurations.compile.map { configuration ->
//        configuration.asFileTree.fold(files().asFileTree) { collection, file ->
//            if (file.isDirectory) collection else collection.plus(zipTree(file))
//        }
//    })
}

tasks.create("stage"){
    dependsOn("jar")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.slack.api:slack-api-client:$slack_version")
    implementation("com.slack.api:slack-api-model-kotlin-extension:$slack_version")
    implementation("com.slack.api:slack-api-client-kotlin-extension:$slack_version")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}