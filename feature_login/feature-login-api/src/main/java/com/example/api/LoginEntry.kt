package com.example.api

import com.example.common.AggregateFeatureEntry
import com.example.common.ComposableFeatureEntry

abstract class LoginEntry : ComposableFeatureEntry, AggregateFeatureEntry {

    final override val featureRoute = "login"

    fun destination() = featureRoute
}
