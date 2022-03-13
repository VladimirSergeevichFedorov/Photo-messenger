package dependenciesForModules

object Retrofit {

    /**
     * [Retrofit](https://github.com/square/retrofit)
     * A type-safe HTTP client for Android and Java.
     */
    internal val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"

    /**
     * [Converter: Gson](https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson)
     * A Retrofit Converter which uses Gson for serialization.
     */
    internal val convertGson = "com.squareup.retrofit2:converter-gson:${Versions.gsonVersion}"

    /**
     * [OkHttp Logging Interceptor]
     * (https://mvnrepository.com/artifact/com.squareup.okhttp3/logging-interceptor)
     * Square’s meticulous HTTP client for Java and Kotlin.
     */
    internal val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptorVersion}"

    internal val retrofitList = listOf(retrofit, convertGson, interceptor)
}
