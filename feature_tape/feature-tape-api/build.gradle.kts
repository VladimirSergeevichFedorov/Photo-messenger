plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Android.compileSdk

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
