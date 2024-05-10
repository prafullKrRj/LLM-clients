plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.prafull"
version = "1.0"

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
tasks {
    jar {
        manifest {
            attributes["Implementation-Title"] = "LLMs Client" // The project name
            attributes["Implementation-Version"] = version // Project version
        }
    }
}