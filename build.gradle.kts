import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.6.21"  apply false
    kotlin("plugin.spring") version "1.6.21"  apply false
    id("org.springframework.boot") version "2.6.7" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.3.61" apply false
    idea

}
group = "com.bbl"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
apply {
    plugin("java")
    plugin("org.jetbrains.kotlin.jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    val implementation by configurations
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("allopen"))
    implementation(kotlin("noarg"))
    implementation(kotlin("reflect"))

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.jsonwebtoken:jjwt:0.9.1")
    implementation("com.google.code.gson:gson")

    // log
    implementation("io.github.microutils:kotlin-logging:1.7.8")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
