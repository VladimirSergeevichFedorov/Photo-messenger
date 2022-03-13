package com.example.api

import androidx.compose.runtime.compositionLocalOf

interface LoginProvider

val LocalLoginProvider = compositionLocalOf<LoginProvider> {
    error("No login provider found!")
}