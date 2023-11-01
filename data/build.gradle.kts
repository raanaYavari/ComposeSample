plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.raana.composeSample.data"
    compileSdk = Config.COMPILE_SDK
    android.buildFeatures.buildConfig = true
    defaultConfig {
        minSdk = Config.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com\"")
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://jsonplaceholder.typicode.com\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(Dependencies1.ANDROIDX_CORE)
    implementation(Dependencies1.ANDROIDX_APPCOMPACT)
    implementation(Dependencies1.MATERIAL)
    implementation(Dependencies1.HILT_ANDROID)

    kapt(Dependencies1.HILT_COMPILER)
    implementation(Dependencies1.RETROFIT)
    implementation(Dependencies1.RETROFIT_CONVERTER_SCALARS)
    implementation(Dependencies1.LOGGING_INTERCEPTOR)
    implementation(Dependencies1.COROUTINE_CORE)
    implementation(Dependencies1.COROUTINE_ANDROID)
    implementation(Dependencies1.KOTLIN_X_SERIALIZATION)
    implementation(Dependencies1.KOTLIN_SERIALIZATION_CONVERTOR)
    implementation(Dependencies1.DATA_STORE)
    api(project(":domain"))
}