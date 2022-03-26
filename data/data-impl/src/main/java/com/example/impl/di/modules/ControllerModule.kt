package com.example.impl.di.modules

import com.example.impl.retrofit.NetworkController
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ControllerModule {

    @Provides
    fun provideTapeController(retrofit: Retrofit): NetworkController =
        retrofit.create(NetworkController::class.java)
}