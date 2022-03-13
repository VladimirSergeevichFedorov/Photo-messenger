package com.example.photoch.di.modules

import com.example.impl.di.LoginModule
import dagger.Module

@Module(
    includes = [
        LoginModule::class
    ]
)
interface NavigationModule