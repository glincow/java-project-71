plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.52.0"
    id("application")
    id("jacoco")
    id("checkstyle")
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.0.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.2")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass = "hexlet.code.App"
}

sonar {
    properties {
        property("sonar.projectKey", "glincow_java-project-71")
        property("sonar.organization", "glincow")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }
