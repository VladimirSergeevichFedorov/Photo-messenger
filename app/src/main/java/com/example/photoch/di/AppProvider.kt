package com.example.photoch.di

import androidx.compose.runtime.compositionLocalOf
import com.example.api.DataProvider
import com.example.domain.Destinations
import com.example.domain.di.CommonProvider

interface AppProvider :
    DataProvider,
    CommonProvider {

    val destinations: Destinations

}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
