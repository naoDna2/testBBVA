plugins {
    alias(libs.plugins.android.ksp)
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.android.hilt)
    alias(libs.plugins.jetbrainsKotlinSerialization )
}

android {
    namespace = "com.naomi.pruebabbva"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.naomi.pruebabbva"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            buildConfigField("String","URL_BBVA_LOGIN", "\"https://private-6eaf4c-examenbbva.apiary-mock.com\"")
            buildConfigField("String","URL_BBVA_IMAGES", "\"https://dog.ceo\"")
            buildConfigField("long","NETWORK_TIME_OUT", "20")
        }
        release {
            isMinifyEnabled = false
            buildConfigField("String","URL_BBVA_LOGIN", "\"https://private-6eaf4c-examenbbva.apiary-mock.com\"")
            buildConfigField("String","URL_BBVA_IMAGES", "\"https://dog.ceo\"")
            buildConfigField("long","NETWORK_TIME_OUT", "20")

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
        buildConfig = true
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
    implementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.androidx.ui.material.icons)

    //Navigation compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    //HILT
    implementation(libs.android.hilt)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.android.hilt.compiler)

    //OKHTTP3
    implementation(libs.android.okhttp3)
    implementation(libs.android.okhttp3.loggging)

    //RETROFIT
    implementation(libs.android.retrofit)
    implementation(libs.android.retrofit.gson)

    //Splash
    implementation(libs.androidx.core.splash)


    //COIL
    implementation(libs.android.coil)
}