package com.example.feature_tape_impl.di

import com.example.api.DataProvider
import com.example.feature_tape_api.TapeProvider
import com.example.feature_tape_impl.ui.viewModel.TapeScreenViewModel
import dagger.Component

@Component(
    dependencies = [DataProvider::class]
)
interface TapeComponent : TapeProvider {
    val tapeScreenViewModel: TapeScreenViewModel
}