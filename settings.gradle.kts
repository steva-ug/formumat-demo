include(":androidApp")
include(":shared")
include(":desktopApp")
include(":webApp")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val composeVersion = extra["compose.version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)

        id("org.jetbrains.compose").version(composeVersion)
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.4.0")
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

val localprops = java.util.Properties().apply {
    try {
        load(java.io.File("local.properties").inputStream())
    } catch (ignored: Throwable) {
    }
}
if (localprops.containsKey("formumat-public.dir")) {
    include("formumat-public")
    project(":formumat-public").projectDir = File(localprops.getProperty("formumat-public.dir"))
}
if (localprops.containsKey("expressions.dir")) {
    include("expressions")
    project(":expressions").projectDir = File(localprops.getProperty("expressions.dir"))
}
