import java.util.Properties

val localprops = Properties().apply {
    try {
        load(File("local.properties").inputStream())
    } catch (ignored: Throwable) {
    }
}

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    js(IR) {
        moduleName = "formumat-demo"
        browser {
            commonWebpackConfig {
                outputFileName = "formumat-demo.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.runtime)
                // 1. option: Use the common UI which will be rendered into a canvas
                implementation(compose.ui)
                implementation(compose.foundation)
                // 1. option
                // 2. option: User HTML DOM elements
                // implementation(compose.html.core)
                // 2. option
                implementation(project(":shared"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            }
        }
    }
}

compose.experimental {
    web.application {}
}
