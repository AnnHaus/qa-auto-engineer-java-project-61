plugins {
    application
    id("com.github.ben-manes.versions") version "0.54.0"
    id("com.github.spotbugs") version "6.5.8"
    checkstyle
}

checkstyle {
    toolVersion = "10.12.4"
    configFile = rootProject.file("app/config/checkstyle/checkstyle.xml")
    isIgnoreFailures = false
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
    ignoreFailures.set(true)
}

tasks.withType<com.github.spotbugs.snom.SpotBugsTask>().configureEach {
    reports {
        create("sarif") { required.set(false) }
        
        create("xml") {
            required.set(true)
            outputLocation.set(layout.buildDirectory.file("reports/spotbugs/main.xml"))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

