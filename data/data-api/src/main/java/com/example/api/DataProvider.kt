/*
 * Copyright 2021 Pavlo Stavytskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.api

import androidx.compose.runtime.compositionLocalOf
import com.example.domain.repositories.AuthoriseRepo
import com.example.domain.usecase.GetUserDataUseCase
import com.example.domain.repositories.ProtoUserRepo
import com.example.domain.repositories.RegisterRepo
import com.example.domain.usecase.SaveUserDataUseCase

interface DataProvider {

//    val imagesRepository: ImagesRepository
//
//    val usersRepository: UsersRepository

    val protoUserRepo: ProtoUserRepo

    val authoriseRepo: AuthoriseRepo

    val registerRepo: RegisterRepo

    val saveUserDataUseCase: SaveUserDataUseCase

    val getUserDataUseCase: GetUserDataUseCase
}

val LocalDataProvider = compositionLocalOf<DataProvider> { error("No data provider found!") }
