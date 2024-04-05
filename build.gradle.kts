plugins {
    kotlin("jvm") version "1.9.22"
    id("io.qameta.allure") version "2.8.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    testImplementation("junit:junit:4.13.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1-Beta")
    testImplementation("io.qameta.allure:allure-kotlin-model:2.4.0")
    testImplementation("io.qameta.allure:allure-kotlin-commons:2.4.0")
    testImplementation("io.qameta.allure:allure-kotlin-junit4:2.4.0")
}

//tasks.test {
//    useJUnitPlatform()
//}
kotlin {
    jvmToolchain(19)
}