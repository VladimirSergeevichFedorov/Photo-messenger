package com.example.impl.di.modules

import com.example.domain.usecase.GetTapeUsersUseCase
import com.example.domain.usecase.GetUserDataUseCase
import com.example.domain.usecase.SaveUserDataUseCase
import com.example.impl.proto.ProtoUserRepoImpl
import com.example.impl.repositories.TapeRepoImpl
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

    @Provides
    fun provideGetTapeUsersUseCase(tapeRepoImpl: TapeRepoImpl) =
        GetTapeUsersUseCase(tapeRepo = tapeRepoImpl)
}
