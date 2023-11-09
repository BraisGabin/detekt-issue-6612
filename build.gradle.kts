import io.gitlab.arturbosch.detekt.Detekt

plugins {
    kotlin("jvm") version "1.9.10"
    id("io.gitlab.arturbosch.detekt").version("1.23.3")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
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
}
