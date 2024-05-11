plugins {
    kotlin("jvm") version "1.9.23"
    `maven-publish`
    signing
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
java {
    withSourcesJar()
    withJavadocJar()
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            // Provide artifacts information required by JitPack
            artifact(tasks.getByName("sourcesJar"))
            artifact(tasks.getByName("javadocJar"))

            pom {
                name.set("llm-client")
                description.set("A llm-client which provides functions to use different LLMs")
                url.set("https://github.com/prafullKrRj/LLM-clients")
                developers {
                    developer {
                        id.set("prafullKrRj")
                        name.set("Prafull Kumar")
                        email.set("prafullcodes@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/prafullKrRj/LLM-clients.git")
                    developerConnection.set("scm:git:ssh://github.com/prafullKrRj/LLM-clients.git")
                    url.set("https://github.com/prafullKrRj/LLM-clients")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/prafullKrRj/LLM-clients")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
}
signing {

}