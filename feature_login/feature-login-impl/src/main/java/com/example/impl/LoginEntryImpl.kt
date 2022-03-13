package com.example.impl

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.api.LocalDataProvider
import com.example.api.LoginEntry
import com.example.domain.Destinations
import com.example.domain.di.injectedViewModel
import com.example.feature_login.LoginAuthScreen
import com.example.feature_login.ui.screen.LoginRegisterScreen
import com.example.impl.di.DaggerLoginComponent
import javax.inject.Inject

class LoginEntryImpl @Inject constructor() : LoginEntry() {

    @SuppressLint("ComposableNavGraphInComposeScope", "ComposableDestinationInComposeScope")
    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val viewModel = injectedViewModel {
            DaggerLoginComponent.builder()
                .dataProvider(LocalDataProvider.current)
                .build()
                .loginScreenViewModel
        }
        LoginAuthScreen(navController, viewModel)
    }

    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = destination(), route = "@login") {
            composable(route = featureRoute) {
                val viewModel = injectedViewModel {
                    DaggerLoginComponent.builder()
                        .dataProvider(LocalDataProvider.current)
                        .build()
                        .loginScreenViewModel
                }
                LoginAuthScreen(navController, viewModel)
            }
            composable(route = InternalRoutes.REGISTRATION) {
                val viewModel = injectedViewModel {
                    DaggerLoginComponent.builder()
                        .dataProvider(LocalDataProvider.current)
                        .build()
                        .loginRegisterScreenViewModel
                }
                LoginRegisterScreen(navController, viewModel)
            }
        }
    }

    internal object InternalRoutes {
        const val REGISTRATION = "registration"
        const val LOGIN = "login"
    }
}
