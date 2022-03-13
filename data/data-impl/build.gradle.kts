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

        kotlinCompilerExtensionVersion = "1.0.0"
    }
}

dependencies {
    api(project(ModulesForApi.data))
//    implementation(project(ModulesForApi.data))
    implementation(project(Modules.common))

    implementation(AppDependencies.featureDomainLibraries)
    kapt(AppDependencies.diLibrariesKapt)

//    implementation("com.google.dagger:dagger-android:2.35.1")
////    implementation 'com.google.dagger:dagger-android-support:2.x' // if you use the support libraries
//    annotationProcessor("com.google.dagger:dagger-android-processor:2.27")
//    annotationProcessor("com.google.dagger:dagger-compiler:2.36")
//
    implementation("androidx.datastore:datastore-core:1.0.0")
    api("com.google.protobuf:protobuf-javalite:3.19.4")
//    api("androidx.preference:preference-ktx:1.2.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
//    implementation("androidx.appcompat:appcompat:1.4.1")
//    implementation("com.google.android.material:material:1.5.0")
//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
//    implementation("androidx.core:core-ktx:+")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.4"
    }
//    generateProtoTasks {
//        all().forEach { task ->
//            task.plugins {
//                create("java") {
//                    option("lite")
//                }
//            }
//        }
//    }
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
