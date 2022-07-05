import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    base
    kotlin("jvm") version "1.6.21"  apply false
    kotlin("plugin.spring") version "1.6.21"  apply false
    id("org.springframework.boot") version "2.6.7" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    id("org.jetbrains.kotlin.kapt") version "1.3.61" apply false
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.21" apply false
    idea
}

allprojects {
    group = "com.bbl"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }

    apply {
        plugin("java")
        plugin("org.jetbrains.kotlin.jvm")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("io.spring.dependency-management")
        plugin("idea")
    }

    idea {
        module {
            val kaptMain = file("build/generated/source/kaptKotlin/main")
            sourceDirs.add(kaptMain)
            generatedSourceDirs.add(kaptMain)
        }
    }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    // log4j 취약점 조치 - 2021.12.14
    configurations.all {
        resolutionStrategy.eachDependency {
            if (this.requested.group == "org.apache.logging.log4j") {
                this.useVersion("2.17.0")
            }
        }
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
}

project(":matching") {
    dependencies {
        val implementation by configurations
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    }

project(":bokbuin") {
    dependencies {
        val implementation by configurations
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
    }
}
}

