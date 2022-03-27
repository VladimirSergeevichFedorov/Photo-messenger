package com.example.impl.retrofit

import com.example.feature_tape_impl.retrofit.GetAllData
import retrofit2.Response
import retrofit2.http.GET

interface NetworkController {

    @GET("api/users?page=2")
    suspend fun getUserList(): Response<GetAllData>
}
