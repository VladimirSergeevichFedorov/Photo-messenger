buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(DependenciesForProject.gradle)
        classpath(DependenciesForProject.gradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
