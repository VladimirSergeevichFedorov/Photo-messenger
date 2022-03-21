package com.example.photoch.di.modules

import com.example.feature_tape_impl.di.TapeEntryModule
import com.example.impl.di.LoginEntryModule
import dagger.Module

@Module(
    includes = [
        LoginEntryModule::class,
        TapeEntryModule::class
    ]
)
interface NavigationModule