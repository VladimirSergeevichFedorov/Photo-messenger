package com.example.feature_tape_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.api.DataProvider
import com.example.api.LocalDataProvider
import com.example.common.Destinations
import com.example.common.di.injectedViewModel
import com.example.common.find
import com.example.feature_tape_api.TapeEntry
import com.example.feature_tape_impl.di.DaggerTapeComponent
import com.example.feature_tape_impl.di.user.DaggerUserComponent
import com.example.feature_tape_impl.ui.screen.TapeScreen
import com.example.feature_tape_impl.ui.screen.UserScreen
import javax.inject.Inject

class TapeEntryImpl @Inject constructor() : TapeEntry() {

    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = InternalRoutesTape.TAPE, route = "@tape") {
            composable(route = InternalRoutesTape.TAPE) {
                val viewModel = injectedViewModel {
                    DaggerTapeComponent.builder()
                        .dataProvider(LocalDataProvider.current)
                        .build()
                        .tapeScreenViewModel
                }
                TapeScreen(
                    navController = navController,
                    viewModel = viewModel,
                    onUserSelected = { userId ->
                        val tapeDestination = destinations
                            .find<TapeEntry>()
                            .userProfileDestination(userId)
                        navController.navigate(tapeDestination)
                    }
                )
            }
            composable(route = featureRoute, arguments) {
                val viewModel = injectedViewModel {
                    val userId = it.arguments?.getString(ARG_USER_ID)
                    DaggerUserComponent.factory()
                        .create(buildRootTapeComponent(LocalDataProvider.current), userId)
                        .userScreenViewModel
                }
                UserScreen(
                    viewModel = viewModel
                )
            }
        }
    }

    private fun buildRootTapeComponent(dataProvider: DataProvider) =
        DaggerTapeComponent.builder().dataProvider(dataProvider).build()

    internal object InternalRoutesTape {
        const val USER = "user"
        const val TAPE = "tape"
    }
}
