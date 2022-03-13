plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    // Plugins are declared in gradle/libs.versions.toml
    // Precompiled plugin with the base android configuration.
    // Declared in buildSrc/.../android-config.gradle.kts.
}
//android {
//    compileSdk = Android.compileSdk
//
//    buildTypes {
//        release {
//            isMinifyEnabled = true
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//
//    buildFeatures.compose = true
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.0.0"
//    }
//}
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
    buildFeatures {
        compose = true
    }
    composeOptions {

        kotlinCompilerExtensionVersion = "1.0.0"
    }
}
dependencies {

//    feature-login-data-api(project(ModulesForApi.featureLogin))
//    implementation(project(ModulesForApi.featureLogin))
    implementation(project(Modules.common))
    implementation(project(ModulesForApi.data))
    api(project(ModulesForApi.featureLogin))

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    implementation(AppDependencies.featureLoginLibraries)
    kapt(AppDependencies.diLibrariesKapt)
}
