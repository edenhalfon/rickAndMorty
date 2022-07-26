import Dependencies.AndroidX
import Dependencies.Kotlin
import Dependencies.Test

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }

    dataBinding.isEnabled = true
}

dependencies {
    implementation(project(":core"))
    implementation(AndroidX.CoreKtx)
    implementation(AndroidX.AppCompat)
    implementation(AndroidX.Material)
    implementation(AndroidX.ConstraintLayout)

    implementation(Kotlin.Stdlib)
    implementation(Kotlin.Coroutines)
    implementation(Dependencies.Core.koin)
    implementation(Dependencies.Core.koinNavigation)
    implementation(AndroidX.Navigation)
    implementation(AndroidX.NavigationUi)
    implementation(AndroidX.splashScreen)
    implementation(Dependencies.UI.imageLoader)

    testImplementation(Test.Junit)

    androidTestImplementation(Test.JunitExt)
    androidTestImplementation(Test.EspressoCore)
}