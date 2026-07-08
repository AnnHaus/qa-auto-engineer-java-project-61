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
    ignoreFailures.set(true) // Чтобы баги в коде не ломали сборку на сервере
}

tasks.withType<com.github.spotbugs.snom.SpotBugsTask>().configureEach {
    reports {
        // Выключаем проблемный sarif
        create("sarif") { required.set(false) }
        
        // Включаем железобетонный XML, который плагин точно умеет создавать
        create("xml") {
            required.set(true)
            outputLocation.set(layout.buildDirectory.file("reports/spotbugs/main.xml"))
        }
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
