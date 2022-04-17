package com.example.impl.di.modules

import com.example.domain.repositories.AuthoriseRepo
import com.example.domain.repositories.ProtoUserRepo
import com.example.domain.repositories.RegisterRepo
import com.example.impl.mapping.DataMapper
import com.example.impl.mapping.MappersUserData
import com.example.impl.proto.ProtoUserRepoImpl
import com.example.impl.repositories.AuthoriseRepoImpl
import com.example.impl.repositories.RegisterRepoImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    fun bindProtoDataStore(impl: ProtoUserRepoImpl): ProtoUserRepo

    @Binds
    fun bindLoginRepo(impl: AuthoriseRepoImpl): AuthoriseRepo

    @Binds
    fun bindRegisterRepo(impl: RegisterRepoImpl): RegisterRepo

    @Binds
    @Singleton
    fun mapper(impl: MappersUserData): DataMapper
}
