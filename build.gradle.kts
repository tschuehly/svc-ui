import kotlin.io.path.Path

plugins {
    java
    id("org.springframework.boot") version "4.0.9"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.graalvm.buildtools.native") version "0.11.5"
    id("gg.jte.gradle") version "3.2.1"
}

group = "de.tschuehly"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("de.tschuehly:spring-view-component-jte:0.9.1")
    jteGenerate("gg.jte:jte-native-resources:3.2.1")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
}

// Kamal requires the image label service=<service> (deploy/apps/svc-ui/config/deploy.yml).
tasks.bootBuildImage {
    environment.put("BP_IMAGE_LABELS", "service=svc-ui")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jte {
    generate()
    jteExtension("gg.jte.nativeimage.NativeResourcesExtension")
    sourceDirectory = Path("src/main/java")
}
