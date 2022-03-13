package dependenciesForModules

object UI {
    /**
     * [Material Components For Android]
     * (https://mvnrepository.com/artifact/com.google.android.material/material)
     * Material Components for Android is a static library that you can add to your Android
     * application in order to use APIs that provide implementations of the
     * Material Design specification. Compatible on devices running API 14 or later.
     */
    internal val material = "com.google.android.material:material:${Versions.material}"

    /**
     * [Android AppCompat Library] (https://mvnrepository.com/artifact/androidx.appcompat/appcompat)
     * The Support Library is a static library that you can add to your Android application in order
     * to use APIs that are either not available for older platform versions or utility APIs that
     * aren't a part of the framework APIs. Compatible on devices running API 14 or later.
     */
    internal val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"

    /**
     * [Core Kotlin Extensions] (https://mvnrepository.com/artifact/androidx.core/core-ktx)
     * Kotlin extensions for 'core' artifact.
     */
    internal val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    internal val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coreKtx}"

    val uiList = listOf(material, appcompat, coreKtx, lifecycle)
}
