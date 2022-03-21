package com.example.feature_tape_impl.di

import com.example.common.di.FeatureEntryKey
import com.example.feature_tape_api.TapeEntry
import com.example.feature_tape_impl.TapeEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface TapeEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(TapeEntry::class)
    fun tapeEntry(impl: TapeEntryImpl): TapeEntry
}
