import com.google.protobuf.gradle.*

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.protobuf") version "0.8.12"
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
    buildFeatures {
        compose = true
    }
    composeOptions {

        kotlinCompilerExtensionVersion = "1.1.0"
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    api(project(ModulesForApi.data))
    implementation(project(Modules.common))
    implementation(project(Modules.domain))

    implementation(AppDependencies.dataLibraries)

    implementation("androidx.datastore:datastore-core:1.0.0")
    api("com.google.protobuf:protobuf-javalite:3.19.4")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    kapt(AppDependencies.diLibrariesKapt)
//    kaptTest(AppDependencies.testKapt)
//    kaptAndroidTest(AppDependencies.testAndroidKapt)
//    testImplementation(AppDependencies.testLibraries)
//    androidTestImplementation(AppDependencies.androidTestLibraries)
//
//    testImplementation("io.mockk:mockk:1.10.5")
//    testImplementation("org.hamcrest:hamcrest-all:1.3")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
            }
        }
    }
}
