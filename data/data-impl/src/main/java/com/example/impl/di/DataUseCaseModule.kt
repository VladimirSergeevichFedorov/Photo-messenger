package com.example.impl.di

import com.example.domain.usecase.GetUserDataUseCase
import com.example.domain.usecase.SaveUserDataUseCase
import com.example.impl.proto.ProtoUserRepoImpl
import dagger.Module
import dagger.Provides

@Module
class DataUseCaseModule {

    @Provides
    fun provideSaveUserDataUseCase(protoUserRepoImpl: ProtoUserRepoImpl) =
        SaveUserDataUseCase(protoUserRepo = protoUserRepoImpl)

    @Provides
    fun provideGetUserDataUseCase(protoUserRepoImpl: ProtoUserRepoImpl) =
        GetUserDataUseCase(protoUserRepo = protoUserRepoImpl)
}
