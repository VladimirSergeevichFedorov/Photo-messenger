package dependenciesForModule

object Room {
     val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
     val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    // To use Kotlin annotation processing tool (kapt)
    val roomCompilerKapt = "androidx.room:room-compiler:${Versions.roomVersion}"

    // optional - Kotlin Extensions and Coroutines support for Room
     val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
}
