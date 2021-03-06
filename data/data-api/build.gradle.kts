plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Android.compileSdk

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        multiDexEnabled = true

        testInstrumentationRunner = Android.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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

    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0"
    }
}
dependencies {
    implementation(project(Modules.common))
    implementation(project(Modules.domain))

    implementation(AppDependencies.featuresApi)
}
