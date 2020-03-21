plugins {
    id("com.github.ben-manes.versions").version(Versions.versions_plugin)
}

buildscript {
    repositories {
        mavenLocal()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.github.ben-manes:gradle-versions-plugin:${Versions.versions_plugin}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    }
}

plugins.apply("kotlin")
plugins.apply("maven")

dependencies {
    "implementation"("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    "implementation"("com.squareup.okio:okio:${Versions.okio}")
    "testCompile"("org.junit.jupiter:junit-jupiter-api:${Versions.jupiter}")
    "testCompile"("org.junit.jupiter:junit-jupiter-params:${Versions.jupiter}")
    "testRuntime"("org.junit.jupiter:junit-jupiter-engine:${Versions.jupiter}")

    "testImplementation"("org.jetbrains.kotlin:kotlin-test")
    "testImplementation"("com.google.truth:truth:1.0.1")


}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

repositories {
    jcenter()
    maven("https://jitpack.io")
}
