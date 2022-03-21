package com.example.feature_tape_api

import com.example.common.AggregateFeatureEntry

abstract class TapeEntry : AggregateFeatureEntry {

    final override val featureRoute = "tape"

    fun destination() = featureRoute
}
