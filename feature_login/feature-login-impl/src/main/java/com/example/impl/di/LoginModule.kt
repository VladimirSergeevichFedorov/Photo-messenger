package com.example.impl.di

import com.example.api.LoginEntry
import com.example.domain.FeatureEntry
import com.example.domain.di.FeatureEntryKey
import com.example.impl.LoginEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface LoginModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(LoginEntry::class)
    fun loginEntry(entry: LoginEntryImpl): FeatureEntry
}