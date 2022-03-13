package com.example.domain.di

import android.content.Context
import androidx.compose.runtime.compositionLocalOf

interface CommonProvider {

    val context: Context
}

val LocalDomainProvider = compositionLocalOf<CommonProvider> { error("No common provider found!") }
