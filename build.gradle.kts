import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("jvm") version "1.9.20"
    id("io.gitlab.arturbosch.detekt").version("1.23.3")
    id("com.google.devtools.ksp").version("1.9.20-1.0.13")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.moshi:moshi:1.15.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.15.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "11"

    doFirst {
        this as Detekt
        println("@@@@@@@@@@@@@@")
        this.source.visit { println(this) }
        println("@@@@@@@@@@@@@@")
    }
}
