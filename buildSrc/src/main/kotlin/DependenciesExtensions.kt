import org.gradle.api.artifacts.dsl.DependencyHandler

// util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}
fun DependencyHandler.kaptTest(list: List<String>) {
    list.forEach { dependency ->
        add("kaptTest", dependency)
    }
}

fun DependencyHandler.kaptAndroidTest(list: List<String>) {
    list.forEach { dependency ->
        add("kaptAndroidTest", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
