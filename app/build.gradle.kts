plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.6.21"
}

android {
    namespace = Config.APPLICATION_ID
    compileSdk = Config.COMPILE_SDK
    defaultConfig {
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(Dependencies.ANDROIDX_APPCOMPACT)
    implementation(Dependencies.ANDROIDX_ACTIVITY)
    implementation(Dependencies.HILT_ANDROID)
    implementation(Dependencies.HILT_NAVIGATION)
    kapt(Dependencies.HILT_COMPILER)
    implementation(Dependencies.STARTUP)
    implementation(Dependencies.COROUTINE_CORE)
    implementation(Dependencies.COROUTINE_ANDROID)
    implementation(Dependencies.LIFECYCLE_LIVEDATA)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.LIFECYCLE_SAVEDSTATE)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL_COMPOSE)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.COMPOSE_RUNTIME)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_FOUNDATION_LAYOUT)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_MATERIAL_ICONS)
    implementation(Dependencies.COMPOSE_FOUNDATION)
    implementation(Dependencies.COMPOSE_ANIMATION)
    implementation(Dependencies.COMPOSE_UI_TOOLING)
    implementation(Dependencies.COMPOSE_RUNTIME_LIVEDATA)
    implementation(Dependencies.ACCOMPANIST_PAGER)
    implementation(Dependencies.ACCOMPANIST_SWIPE_REFRESH)
    implementation(Dependencies.ACCOMPANIST_INSETS)
    implementation(Dependencies.ACCOMPANIST_SYSTEM_UI_CONTROLLER)
    implementation(Dependencies.ACCOMPANIST_PERMISSIONS)
    implementation(Dependencies.NAVIGATION_COMPOSE)
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_SCALARS)
    implementation(Dependencies.LOGGING_INTERCEPTOR)
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.ACCOMPANIST_FLOW_LAYOUT)
    implementation(Dependencies.KOTLIN_X_SERIALIZATION)
}