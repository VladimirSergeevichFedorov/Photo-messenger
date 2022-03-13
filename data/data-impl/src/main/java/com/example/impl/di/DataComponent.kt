package com.example.impl.di

import com.example.api.DataProvider
import com.example.domain.di.CommonProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CommonProvider::class],
    modules = [DataModule::class, DataProtoModule::class]
)
interface DataComponent : DataProvider
