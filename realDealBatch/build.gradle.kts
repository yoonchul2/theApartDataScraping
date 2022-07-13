plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.jpa")
    id("ws.doerr.projects.emailtemplates.gradleplugin") version "0.3.0"
    kotlin("kapt")
    id("org.sonarqube")  version "3.1.1"
    war
}


dependencies {
    // spring boot web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // spring boot webflux - WebClient
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("io.projectreactor:reactor-test")

    // spring boot devtools = 무중단 클래스 로더
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    // spring boot actuator = health check
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    //spring boot test
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // quartz
    implementation("org.springframework.boot:spring-boot-starter-quartz")

    //spring boot jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // queryDsl
    api("com.querydsl:querydsl-jpa:4.2.2")
    kapt("com.querydsl:querydsl-apt:4.2.2:jpa")
    kapt("org.hibernate.javax.persistence", "hibernate-jpa-2.1-api", "1.0.2.Final")

    // retrofit2 + xml parser
    implementation("com.squareup.retrofit2:retrofit:2.7.1")
    implementation("com.squareup.retrofit2:converter-simplexml:2.7.2")

    implementation("mysql:mysql-connector-java")

    //batch
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-quartz")
}

