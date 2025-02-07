import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("androidx.room") version "2.7.0-alpha12"
    id("com.google.devtools.ksp") version "1.9.22-1.0.18"

}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm("desktop")
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing")
            implementation("androidx.room:room-gradle-plugin:2.7.0-alpha12")
            implementation("androidx.room:room-compiler:2.7.0-alpha12")
            implementation("androidx.room:room-runtime:2.7.0-alpha12")
            implementation("androidx.sqlite:sqlite-bundled:2.5.0-alpha12")

        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
        room{
            schemaDirectory("$projectDir/schemas")
            schemaDirectory("debug","$projectDir/schemas/debug")
            schemaDirectory("release","$projectDir/schemas/release")
        }

    }
}

android {
    namespace = "com.asociacion.calculadoracostos"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    buildFeatures {
        compose=true

    }

    defaultConfig {
        applicationId = "com.asociacion.calculadoracostos"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "com.asociacion.calculadoracostos.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.asociacion.calculadoracostos"
            packageVersion = "1.0.0"
        }
    }
}
