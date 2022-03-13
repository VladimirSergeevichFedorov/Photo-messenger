package com.example.impl.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.impl.proto.ProtoUserRepoImpl
import com.example.impl.proto.UserStoreSerializer
import com.example.photoch.UserStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataProtoModule {

    @Provides
    @Singleton
    fun provideSettings(context: Context) = ProtoUserRepoImpl(context.dataStore)

    private val Context.dataStore: DataStore<UserStore> by dataStore(
        fileName = "userStore.proto",
        serializer = UserStoreSerializer
    )
}
