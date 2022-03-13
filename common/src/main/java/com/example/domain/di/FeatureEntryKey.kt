package com.example.domain.di

import com.example.domain.FeatureEntry
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)