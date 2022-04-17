package com.example.feature_tape_api

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.AggregateFeatureEntry

abstract class TapeEntry :
    AggregateFeatureEntry {

//    final override val featureRoute = "tape"
//
    /**
     * Declares an entry route of the feature.
     */
    final override val featureRoute = "user?$ARG_USER_ID={$ARG_USER_ID}"

//    fun destination() = featureRoute

    /**
     * Declares arguments of an entry route of the feature.
     */
    final override val arguments = listOf(
        navArgument(ARG_USER_ID) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        }
    )

    /**
     * Builds destination to the profile page of a specific user.
     */
    fun userProfileDestination(userId: String): String =
        "user?$ARG_USER_ID=$userId"

    /**
     * Builds destination to the profile page of current user.
     */
    fun myProfileDestination(): String =
        "user"

    protected companion object {
        const val ARG_USER_ID = "userId"
    }
}
