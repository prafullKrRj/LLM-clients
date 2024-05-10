plugins {
    kotlin("jvm") version "1.9.23"
    id("maven-publish")
}

group = "com.github.prafullKrRj"
version = "1.0.0"

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
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = group.toString() // Converts group ID to string
            artifactId = "llm-client" // The artifact ID (project name)
            version = version // Converts version to string
        }
    }
}