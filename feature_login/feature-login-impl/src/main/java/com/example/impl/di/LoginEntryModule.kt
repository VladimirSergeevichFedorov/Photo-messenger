package com.example.impl.di

import com.example.api.LoginEntry
import com.example.common.FeatureEntry
import com.example.common.di.FeatureEntryKey
import com.example.impl.LoginEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface LoginEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(LoginEntry::class)
    fun loginEntry(entry: LoginEntryImpl): FeatureEntry
}