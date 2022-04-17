package com.example.impl.di.modules

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.impl.mapping.DataMapper
import com.example.impl.proto.ProtoUserRepoImpl
import com.example.impl.proto.UserStoreSerializer
import com.example.photoch.UserStore
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class DataProtoModule {

    @Provides
    @Singleton
    @Inject
    fun provideSettings(context: Context, mapper: DataMapper) =
        ProtoUserRepoImpl(context.dataStore, mapper)

    private val Context.dataStore: DataStore<UserStore> by dataStore(
        fileName = "userStore.proto",
        serializer = UserStoreSerializer
    )
}
