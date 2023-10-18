@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinSymbolProcessor)
    alias(libs.plugins.daggerHilt)
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.sqldelight)
}

android {
    namespace = "io.github.l2hyunwoo.translator.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "io.github.l2hyunwoo.translator.android"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources.excludes.apply {
            resources.excludes.add("META-INF/versions/**")
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.hilt)
    ksp(libs.hilt.ksp)
    ksp(libs.hilt.plugin)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.android)
    debugImplementation(libs.compose.ui.tooling)
}
