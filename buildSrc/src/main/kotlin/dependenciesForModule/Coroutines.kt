package dependenciesForModules

object Coroutines {
    /**
     * [Kotlinx Coroutines Core](https://github.com/Kotlin/kotlinx.coroutines)
     * Coroutines support libraries for Kotlin
     */
    internal val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

    /**
     * [Kotlinx Coroutines Android](https://github.com/Kotlin/kotlinx.coroutines)
     * This gives you access to the Android Dispatchers.Main coroutine dispatcher and also
     * makes sure that in case of a crashed coroutine with an unhandled exception that this
     * exception is logged before crashing the Android application, similarly to the way uncaught
     * exceptions in threads are handled by the Android runtime.
     */
    internal val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"

    /**
     * [Android Lifecycle ViewModel Kotlin Extensions]
     * (https://developer.android.com/jetpack/androidx/releases/lifecycle#2.3.0)
     * Lifecycle-aware components perform actions in response to a change in the lifecycle status
     * of another component, such as activities and fragments. These components help you produce
     * better-organized, and often lighter-weight code, that is easier to maintain.
     */
    internal val coroutinesViewmodelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}"
    val coroutinesList = listOf(coroutinesCore, coroutinesAndroid, coroutinesViewmodelKtx)
}
