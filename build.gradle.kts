plugins {
    kotlin("jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.5.0"
}

group = "com.github.zpeg"
version = "0.1.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        // Base IDE the sandbox runs and the plugin compiles against.
        // Swap for clion/goland/etc; Kage support is IDE-agnostic.
        intellijIdeaCommunity("2024.2.5")
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "242"
            untilBuild = "252.*"
        }
    }
}

kotlin {
    jvmToolchain(21)
}
