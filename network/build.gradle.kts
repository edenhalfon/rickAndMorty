plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}

android {
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    api(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.interceptor)
    implementation(Dependencies.Network.kotlinxSerialization)
    implementation(Dependencies.Network.retrofitSerializationConverter)
    implementation(Dependencies.Core.coroutinesCore)
    implementation(Dependencies.Kotlin.Coroutines)

    testImplementation(Dependencies.Test.Junit)
    androidTestImplementation(Dependencies.Test.JunitExt)
    androidTestImplementation(Dependencies.Test.EspressoCore)
}