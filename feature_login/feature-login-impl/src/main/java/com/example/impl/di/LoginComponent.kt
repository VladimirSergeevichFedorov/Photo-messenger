package com.example.impl.di

import com.example.api.DataProvider
import com.example.api.LoginProvider
import com.example.domain.di.FeatureScoped
import com.example.feature_login.ui.viewModel.LoginRegisterScreenViewModel
import com.example.feature_login.ui.viewModel.LoginScreenViewModel
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DataProvider::class],
    modules = [LoginUseCaseModule::class]
)
interface LoginComponent : LoginProvider {

    val loginRegisterScreenViewModel: LoginRegisterScreenViewModel

    val loginScreenViewModel: LoginScreenViewModel
}
