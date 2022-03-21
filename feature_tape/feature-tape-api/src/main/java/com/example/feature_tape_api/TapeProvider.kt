package com.example.feature_tape_api

import androidx.compose.runtime.compositionLocalOf

interface TapeProvider

val LocalTapeProvider = compositionLocalOf<TapeProvider> {
    error("No tape provider found!")
}