package com.example.impl.di

import com.example.domain.domain.ProtoUserRepo
import com.example.impl.usecase.AuthoriseRepo
import com.example.impl.usecase.AuthoriseRepoImpl
import dagger.Binds
import dagger.Module

@Module
interface LoginUseCaseModule {
    @Binds
    fun bindLoginRepo(impl: AuthoriseRepoImpl): AuthoriseRepo
}