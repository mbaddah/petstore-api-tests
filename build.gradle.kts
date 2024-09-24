
plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val allureVersion = "2.25.0"


dependencies {
    testImplementation("io.rest-assured:rest-assured:5.5.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    testImplementation("io.qameta.allure:allure-rest-assured")
    testImplementation("io.rest-assured:json-schema-validator:5.5.0")
}

tasks.test {
    useJUnitPlatform()
    reports {
        junitXml.required.set(true)
        html.required.set(true)
    }
}

//allure {
//    version.set("2.13.0")
//    autoconfigure.set(true)
//    clean.set(true)
//}