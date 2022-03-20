package com.example.impl.di

import com.example.api.DataProvider
import com.example.api.LoginProvider
import com.example.feature_login.ui.viewModel.LoginRegisterScreenViewModel
import com.example.feature_login.ui.viewModel.LoginScreenViewModel
import dagger.Component

@Component(
    dependencies = [DataProvider::class],
    modules = []
)
interface LoginComponent : LoginProvider {

    val loginRegisterScreenViewModel: LoginRegisterScreenViewModel

    val loginScreenViewModel: LoginScreenViewModel
}
