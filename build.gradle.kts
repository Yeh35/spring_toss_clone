import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    kotlin("plugin.jpa") version "1.3.72"
    kotlin("kapt") version "1.4.10"

    id("org.springframework.boot") version "2.3.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

group = "me.sangoh.spring_toss_clone"
version = "1.0.1-SNAPSHOT-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // querydsl
    implementation("com.querydsl:querydsl-jpa:4.2.1")
    kapt("com.querydsl:querydsl-apt:4.2.2:jpa")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    // DB
    testRuntimeOnly("com.h2database:h2")
    runtimeOnly("mysql:mysql-connector-java")

    // API 설명서
    implementation ("io.springfox:springfox-swagger2:2.9.2")
    implementation ("io.springfox:springfox-swagger-ui:2.9.2")

    // 다국적 메시지 기능
    implementation("net.rakugakibox.util:yaml-resource-bundle:1.1")
}

// querydsl 적용
sourceSets["main"].withConvention(KotlinSourceSet::class){
    kotlin.srcDir("$buildDir/generated/source/kapt/main")  // QClass 생성 위치
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

//querydsl {
//    library = "com.querydsl:querydsl-apt"
//    jpa = true
//    querydslSourcesDir = querydslSrcDir
//}

//sourceSets {
//    main {
//        kotlin {
//            srcDirs = ["src/main/java", querydslSrcDir]
//        }
//    }
//}

//configurations {
//    querydsl.extendsFrom compileClasspath
//    developmentOnly
//
//    runtimeClasspath {
//        extendsFrom developmentOnly
//    }
//
//    compileOnly {
//        extendsFrom(configurations.annotationProcessor.get())
//    }
//}
//
//compileQuerydsl {
//    options.annotationProcessorPath = configurations.querydsl
//}

