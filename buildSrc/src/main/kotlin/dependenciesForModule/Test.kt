package dependenciesForModules

object Test {
    /**
     * [JUnit](https://mvnrepository.com/artifact/junit/junit)
     * JUnit is a unit testing framework for Java, created by Erich Gamma and Kent Beck.
     */
    internal val junit = "junit:junit:${Versions.junit}"

    /**
     * [AndroidX Test Library]
     * (https://mvnrepository.com/artifact/androidx.test.ext/junit)
     * The AndroidX Test Library provides an extensive framework for testing Android apps.
     */
    internal val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"

    /**
     * [AndroidX Test Library]
     * (https://mvnrepository.com/artifact/androidx.test.espresso/espresso-core)
     * The AndroidX Test Library provides an extensive framework for testing Android apps.
     */
    internal val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
