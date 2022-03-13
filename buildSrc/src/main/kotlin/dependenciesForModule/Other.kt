package dependenciesForModules

object Other {
    /**
     * [Kotlin Stdlib] (https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib)
     * Kotlin Standard Library for JVM
     */
    internal val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    /**
     * [Legacy](https://mvnrepository.com/artifact/androidx.legacy/legacy-support-v4)
     * Legacy Support V4
     */
    internal val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"

    /**
     * [Cronet](https://mvnrepository.com/artifact/org.chromium.net/cronet-embedded)
     * High performance implementation of Cronet using native libraries.
     */
    internal val cronet = "org.chromium.net:cronet-embedded:${Versions.cronetEmbedded}"

    /**
     * [Core Kotlin Extensions](https://mvnrepository.com/artifact/androidx.core/core-ktx)
     * Kotlin extensions for 'core' artifact
     */
//    internal val ktx = "androidx.core:core-ktx:${Versions.androidXCore}"
//
//    /**
//     * [EditText Mask](https://github.com/egslava/edittext-mask)
//     * MaskedEditText is a simple Android EditText with customizable input mask support.
//     */
//    internal val maskedEditText = "ru.egslava:MaskedEditText:${Versions.egslava}"

//    /**
//     * [ViewBindingPropertyDelegate](https://github.com/androidbroadcast/ViewBindingPropertyDelegate)
//     * Make work with Android View Binding simpler. The library do:
//     * 1)managing ViewBinding lifecycle and clear reference to it to prevent memory leaks
//     * 2)you don't need to keep nullable reference to Views or ViewBindings
//     * 3)create ViewBinding lazy
//     */
//    internal val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBinding}"

    /**
     * [Insetter](https://github.com/chrisbanes/insetter/)
     * Insetter is a library to help apps handle WindowInsets more easily.
     */
    internal val insetsLib = "dev.chrisbanes.insetter:insetter:${Versions.insetsLib}"
//
//    internal val datastore = "androidx.datastore:datastore-core:1.0.0"
//    internal val protobuf = "com.google.protobuf:protobuf-javalite:3.19.4"

    internal val othersList = listOf(
        insetsLib, cronet, legacy, kotlinStdlib
    )
}
