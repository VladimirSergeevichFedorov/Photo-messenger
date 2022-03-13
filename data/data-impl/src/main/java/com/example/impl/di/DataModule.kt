package com.example.impl.di

import com.example.domain.domain.ProtoUserRepo
import com.example.impl.proto.ProtoUserRepoImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun bindProtoDataStore(impl: ProtoUserRepoImpl): ProtoUserRepo
}
