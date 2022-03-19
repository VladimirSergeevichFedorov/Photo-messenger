plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
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

        kotlinCompilerExtensionVersion = "1.1.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
        unitTests.isIncludeAndroidResources = true
    }
}
android.applicationVariants.all {
    val aptOutputDir = File(buildDir, "generated/source/kapt/${this.unitTestVariant.dirName}")
    this.unitTestVariant.addJavaSourceFoldersToModel(aptOutputDir)
}
dependencies {
    implementation(project(Modules.featureLogin))
    implementation(project(Modules.common))
    implementation(project(Modules.data))
    implementation(project(Modules.domain))

    implementation(AppDependencies.appLibraries)
    kapt(AppDependencies.diLibrariesKapt)
    kaptTest(AppDependencies.testKapt)
    kaptAndroidTest(AppDependencies.testAndroidKapt)
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

    testImplementation("io.mockk:mockk:1.10.5")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
}
