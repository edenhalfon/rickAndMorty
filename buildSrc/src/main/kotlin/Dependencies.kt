object Dependencies {

    object Kotlin {
        const val Stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        const val Coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object AndroidX {
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val CoreKtx = "androidx.core:core-ktx:1.8.0"
        const val Material = "com.google.android.material:material:${Versions.material}"
        const val Navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val NavigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val splashScreen = "androidx.core:core-splashscreen:${Versions.splash}"
        const val dataBinding = "androidx.databinding:databinding-runtime:${Versions.dataBinding}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
        const val retrofitSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.serializationConverter}"
        const val kotlinxSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinxSerialization}"
    }

    object Core {
        const val koin = "io.insert-koin:koin-android:${Versions.koin}"
        const val koinNavigation = "io.insert-koin:koin-androidx-navigation:${Versions.koin}"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    }

    object Test {
        const val EspressoCore = "androidx.test.espresso:espresso-core:3.4.0"

        const val Junit = "junit:junit:4.13.2"
        const val JunitExt = "androidx.test.ext:junit:1.1.3"
    }

    object Room {
        const val room = "androidx.room:room-runtime:${Versions.room}"
        const val ktx = "androidx.room:room-ktx:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
        const val cipher = "net.zetetic:android-database-sqlcipher:${Versions.dbCipher}"
        const val sqlite = "androidx.sqlite:sqlite:${Versions.sqlite}"
    }

    object UI {
        const val imageLoader = "io.coil-kt:coil:${Versions.coil}"
    }
}