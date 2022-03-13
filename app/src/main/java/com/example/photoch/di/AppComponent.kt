package com.example.photoch.di

import com.example.api.DataProvider
import com.example.domain.di.CommonProvider
import com.example.photoch.di.modules.NavigationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        CommonProvider::class,
        DataProvider::class,
    ],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider
