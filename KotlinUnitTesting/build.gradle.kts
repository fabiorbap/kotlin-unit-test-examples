plugins {
    kotlin("jvm") version "2.2.10"
    jacoco
}

group = "com.fabio.kotlin.unittesting"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 4
    testImplementation("junit:junit:4.13.2")

    // (Optional) Mockito for JUnit 4
    // testImplementation("org.mockito:mockito-core:5.14.2")

    // Remove Kotlin test (which targets JUnit 5) if you don't need it with JUnit 4
    // testImplementation(kotlin("test"))
}

tasks.test {
    // Use the JUnit 4 runner
    useJUnit()

    // (Optional) Show more detailed test logs
    // testLogging {
    //     events("PASSED", "FAILED", "SKIPPED")
    // }
}

kotlin {
    jvmToolchain(18)
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}

jacoco {
    toolVersion = "0.8.13"
    reportsDirectory = layout.buildDirectory.dir("customJacocoReportDir")
}