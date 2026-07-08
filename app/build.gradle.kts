plugins {
    java
    application
    id("com.github.ben-manes.versions") version "0.54.0"
    id("com.github.spotbugs") version "6.5.8"
}

        application {
            mainClass.set("hexlet.code.App")
        }

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

spotbugs {
    ignoreFailures.set(false) // Сборка упадет, если SpotBugs найдет критические ошибки
}

tasks.withType<com.github.spotbugs.snom.SpotBugsTask> {
    val sarifReport = reports.create("sarif")

    sarifReport.apply {
        required.set(true)
        outputLocation.set(layout.buildDirectory.file("reports/spotbugs/main.sarif"))
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

spotbugs {
    ignoreFailures.set(true) 
}

tasks.withType<com.github.spotbugs.snom.SpotBugsTask> {
    val sarifReport = reports.create("sarif")

    sarifReport.apply {
        required.set(true)
        outputLocation.set(layout.buildDirectory.file("reports/spotbugs/main.sarif"))
    }
}
