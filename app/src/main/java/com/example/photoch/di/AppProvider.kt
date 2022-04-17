package com.example.photoch.di

import androidx.compose.runtime.compositionLocalOf
import com.example.api.DataProvider
import com.example.api.LoginProvider
import com.example.common.Destinations
import com.example.common.di.CommonProvider
import com.example.feature_tape_api.TapeProvider

interface AppProvider :
    DataProvider,
    CommonProvider,
    LoginProvider,
    TapeProvider {

    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
