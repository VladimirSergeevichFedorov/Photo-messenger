import com.google.protobuf.gradle.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.protobuf") version "0.8.12"
}
android {
    compileSdk = Android.compileSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.featureLogin))
    implementation(project(Modules.common))
    implementation(project(Modules.data))

    implementation(AppDependencies.appLibraries)
    kapt(AppDependencies.diLibrariesKapt)
    kaptTest(AppDependencies.testKapt)
    kaptAndroidTest(AppDependencies.testAndroidKapt)
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

    implementation("androidx.datastore:datastore-core:1.0.0")
    api("com.google.protobuf:protobuf-javalite:3.19.4")
//    api("androidx.preference:preference-ktx:1.2.0")
    implementation("androidx.datastore:datastore-preferences:1.0.0")
//
//    protobuf(files("lib/protos.tar.gz"))
//    protobuf(files("ext/"))

//    implementation("androidx.core:core-ktx:1.7.0")
//    implementation("androidx.appcompat:appcompat:1.4.1")
//    implementation("com.google.android.material:material:1.5.0")
//    implementation("androidx.compose.ui:ui: 1.0.1")
//    implementation("androidx.compose.material:material:1.0.1")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.0.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
//    implementation("androidx.activity:activity-compose:1.4.0")

//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
//    androidTestImplementation "androidx.compose.ui:ui-test-junit4:1.0.1"
//    debugImplementation "androidx.compose.ui:ui-tooling:1.0.1"
//    implementation("androidx.core:core-ktx:+")

//    implementation("androidx.activity:activity-compose:1.4.0")
//
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
