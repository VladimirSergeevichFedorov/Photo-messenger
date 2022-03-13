package com.example.photoch

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.api.LoginEntry
import com.example.domain.find
import com.example.photoch.di.LocalAppProvider

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val loginScreen = destinations.find<LoginEntry>()
//    val profileScreen = destinations.find<ProfileEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController, startDestination = loginScreen.destination()) {
            with(loginScreen) {
                composable(navController, destinations)
            }
            with(loginScreen) {
                navigation(navController, destinations)
            }
        }
    }

//    Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
// //        BottomMenuBar(navController, destinations)
//    }
}
