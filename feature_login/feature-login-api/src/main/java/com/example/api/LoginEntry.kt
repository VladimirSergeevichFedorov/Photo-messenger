package com.example.api

import com.example.domain.AggregateFeatureEntry
import com.example.domain.ComposableFeatureEntry

abstract class LoginEntry : ComposableFeatureEntry, AggregateFeatureEntry {

    final override val featureRoute = "login"

    fun destination() = featureRoute
}
