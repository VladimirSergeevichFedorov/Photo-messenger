package com.example.feature_tape_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.api.LocalDataProvider
import com.example.common.Destinations
import com.example.common.di.injectedViewModel
import com.example.feature_tape_api.TapeEntry
import com.example.feature_tape_impl.di.DaggerTapeComponent

class TapeEntryImpl : TapeEntry() {

    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = destination(), route = "@tape") {
            composable(route = featureRoute) {
                val viewModel = injectedViewModel {
                    DaggerTapeComponent.builder()
                        .dataProvider(LocalDataProvider.current)
                        .build()
                        .tapeScreenViewModel
                }

            }

        }
    }
}
