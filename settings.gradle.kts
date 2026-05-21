pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

// Lets Gradle auto-provision the JDK 21 toolchain regardless of the JDK on PATH.
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "kage-jetbrains"
