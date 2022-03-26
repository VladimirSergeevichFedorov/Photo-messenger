package com.example.impl.di

import com.example.api.DataProvider
import com.example.common.di.CommonProvider
import com.example.impl.di.modules.ControllerModule
import com.example.impl.di.modules.DataModule
import com.example.impl.di.modules.DataProtoModule
import com.example.impl.di.modules.DataUseCaseModule
import com.example.impl.di.modules.RetrofitModule
import com.example.impl.di.modules.StorageModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CommonProvider::class],
    modules = [
        DataModule::class,
        DataProtoModule::class,
        DataUseCaseModule::class,
        RetrofitModule::class,
        ControllerModule::class,
        StorageModule::class
    ]
)
interface DataComponent : DataProvider
