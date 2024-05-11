plugins {
    kotlin("jvm") version "1.9.23"
    `maven-publish`
    signing
    id("java-library")
}

group = "com.github.prafullKrRj"
version = "1.0.0:alpha"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("io.ktor:ktor-client-core:2.2.0") // Ktor HTTP client
    implementation("io.ktor:ktor-client-cio:2.2.0") // CIO engine for HTTP
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}
java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["java"])
                groupId = "com.github.prafullKrRj"
                artifactId = "llm-client"
                version = "1.0.0:alpha"
            }
        }
    }
}