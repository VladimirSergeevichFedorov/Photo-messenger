package dependenciesForModules

object Dagger {

    /**
     * [Dagger](https://github.com/google/dagger)
     * A fast dependency injector for Java and Android.
     * Dagger is a compile-time framework for dependency injection.
     * It uses no reflection or runtime bytecode generation, does all its analysis at compile-time,
     * and generates plain Java source code.
     */
    internal val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"

    /**
     * [Dagger](https://github.com/google/dagger)
     * A fast dependency injector for Java and Android.
     */
    internal val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

//    internal val daggerTest = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
//    internal val daggerAndroidTest = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
}
