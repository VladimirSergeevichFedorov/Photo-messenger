package com.example.feature_tape_api

import com.example.common.AggregateFeatureEntry
import com.example.common.ComposableFeatureEntry

abstract class TapeEntry : ComposableFeatureEntry {

    final override val featureRoute = "tape"

    fun destination() = featureRoute
}
