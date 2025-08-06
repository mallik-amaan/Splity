plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.serialization)
}

android {
    namespace = "com.codinfinity.splity"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.codinfinity.splity"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    // In build.gradle
    implementation(libs.androidx.navigation.compose.v277) // or latest
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.coil.compose)

    //Dagger Hilt Dependencies
    implementation(libs.hilt.android)
    implementation (libs.androidx.hilt.navigation.compose) // ✅ Required for hiltViewModel()
    ksp(libs.hilt.compiler)

    //Retrofit Dependencies
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    //Supabase Dependencies
    implementation(libs.postgrest.kt)
    implementation (libs.storage.kt)
    implementation(libs.supabase.auth.kt)
    implementation (libs.ktor.client.android)
    implementation (libs.ktor.client.core)
    implementation (libs.ktor.utils)
    implementation(libs.supabase.functions.kt)

    //coil dependencies
    implementation(libs.coil.compose.v250)


    //secure datastore preferences
    implementation (libs.androidx.security.crypto)
    implementation (libs.androidx.datastore.preferences)
    implementation(libs.kotlinx.serialization.json)

}