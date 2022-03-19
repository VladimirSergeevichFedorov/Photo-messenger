package com.example.photoch

import android.app.Application
import com.example.common.di.DaggerCommonComponent
import com.example.impl.di.DaggerDataComponent
import com.example.photoch.di.AppProvider
import com.example.photoch.di.DaggerAppComponent


class PhotochApplication : Application() {

    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()

        val commonProvider = DaggerCommonComponent.factory().create(this)

        appProvider = DaggerAppComponent.builder()
            .commonProvider(commonProvider)
            .dataProvider(DaggerDataComponent.builder().commonProvider(commonProvider).build())
            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as PhotochApplication).appProvider
