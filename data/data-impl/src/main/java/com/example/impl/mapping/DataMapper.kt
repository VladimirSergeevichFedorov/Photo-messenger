package com.example.impl.mapping

import com.example.domain.entities.UserDataForTape
import com.example.domain.entities.UserPersonalData
import com.example.feature_tape_impl.retrofit.UserData
import com.example.impl.entities.UserDataForRegistration
import com.example.impl.storage.entity.User

interface DataMapper {

    fun mapToGetUserData(userDataForRegistration: UserDataForRegistration):
        UserPersonalData

    fun mapToSetUserData(userPersonalData: UserPersonalData):
        UserDataForRegistration

    fun mapToGetUserDataForTape(datum: UserData):
        UserDataForTape

    fun mapToGetUserForTape(datum: UserData):
        User

    fun mapPerson(dataUser: User):
        UserDataForTape
}
