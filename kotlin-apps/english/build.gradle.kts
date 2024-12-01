import org.gradle.kotlin.dsl.runtimeOnly

plugins {
    kotlin("jvm") version "2.0.20"
}

group = "shadow.kotlin.english"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-reflect
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.0.20")
    implementation(libs.starter.webflux)
    implementation(libs.starter.mongodb)
}