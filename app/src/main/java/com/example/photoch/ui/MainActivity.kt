package com.example.photoch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import com.example.api.LocalDataProvider
import com.example.domain.di.LocalDomainProvider
import com.example.domain.theme.PhotochTheme
import com.example.photoch.Navigation
import com.example.photoch.appProvider
import com.example.photoch.di.LocalAppProvider

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotochTheme {

                Surface(color = MaterialTheme.colors.background) {
                    CompositionLocalProvider(
                        LocalAppProvider provides application.appProvider,
                        LocalDataProvider provides application.appProvider,
                        LocalDomainProvider provides application.appProvider
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
}
