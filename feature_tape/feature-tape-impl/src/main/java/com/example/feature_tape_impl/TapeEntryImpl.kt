package com.example.feature_tape_impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.api.LocalDataProvider
import com.example.common.Destinations
import com.example.common.di.injectedViewModel
import com.example.feature_tape_api.TapeEntry
import com.example.feature_tape_impl.di.DaggerTapeComponent
import com.example.feature_tape_impl.ui.screen.TapeScreen
import javax.inject.Inject

class TapeEntryImpl @Inject constructor() : TapeEntry() {

//    override fun NavGraphBuilder.navigation(
//        navController: NavHostController,
//        destinations: Destinations
//    ) {
//        navigation(startDestination = destination(), route = "@tape") {
//            composable(route = featureRoute) {
//                val viewModel = injectedViewModel {
//                    DaggerTapeComponent.builder()
//                        .dataProvider(LocalDataProvider.current)
//                        .build()
//                        .tapeScreenViewModel
//                }
//                TapeScreen(viewModel = viewModel)
//            }
//        }
//    }

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val viewModel = injectedViewModel {
            DaggerTapeComponent.builder()
                .dataProvider(LocalDataProvider.current)
                .build()
                .tapeScreenViewModel
        }
        TapeScreen(viewModel = viewModel)
    }
}
