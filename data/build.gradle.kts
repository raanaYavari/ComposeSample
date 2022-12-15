plugins {
    kotlin("kapt")
    kotlin("android")
    id("com.android.library")
}

android {
    namespace = "com.raana.bamacodechallenge.data"
    compileSdk = Config.COMPILE_SDK

    defaultConfig {
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK

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
}

dependencies {
    implementation(Dependencies.ANDROIDX_CORE)
    implementation(Dependencies.ANDROIDX_APPCOMPACT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.HILT_ANDROID)

    kapt(Dependencies.HILT_COMPILER)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_SCALARS)
    implementation(Dependencies.LOGGING_INTERCEPTOR)
    implementation(Dependencies.COROUTINE_CORE)
    implementation(Dependencies.COROUTINE_ANDROID)
    implementation(Dependencies.KOTLIN_X_SERIALIZATION)
    implementation(Dependencies.KOTLIN_SERIALIZATION_CONVERTOR)
    implementation(Dependencies.DATA_STORE)
}