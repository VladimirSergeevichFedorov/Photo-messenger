package com.example.photoch

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.api.LoginEntry
import com.example.common.find
import com.example.feature_tape_api.TapeEntry
import com.example.photoch.di.LocalAppProvider
import com.example.photoch.ui.BottomMenuBar

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val loginScreen = destinations.find<LoginEntry>()
//    val profileScreen = destinations.find<ProfileEntry>()
    val tapeScreen = destinations.find<TapeEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController, startDestination = loginScreen.destination()) {
            with(loginScreen) {
                composable(navController, destinations)
            }
            with(loginScreen) {
                navigation(navController, destinations)
            }
            with(tapeScreen) {
                navigation(navController, destinations)
            }
        }
    }
    val a = navController.currentDestination?.route
    a
//    Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
//        val a: Boolean = destinations.any { it.value.featureRoute.contains("login") }
////            .map {   }
//        val v = destinations.values
//        val k = destinations.keys
//        val f = destinations.map { it }
//        if (navController.currentDestination?.route != "login"){
//            BottomMenuBar(navController, destinations)
//        } else {
//            BottomMenuBar(navController, destinations)
//        }
//
//        destinations.forEach {
//            val a = it.value.featureRoute.contains("login")
//
//
//        }
//        Log.d("TAG", "values: $v")
//        Log.d("TAG", "keys: $k")
//        if (!a) {
//        }
//    }
}
