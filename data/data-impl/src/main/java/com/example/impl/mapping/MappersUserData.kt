package com.example.impl.mapping

import com.example.domain.entities.UserPersonalData
import com.example.impl.entities.UserDataForRegistration

internal fun mapToGetUserData(userDataForRegistration: UserDataForRegistration) =
    UserPersonalData(
        password = userDataForRegistration.password,
        userName = userDataForRegistration.userName,
        mobileNumber = userDataForRegistration.mobileNumber,
        email = userDataForRegistration.email
    )
internal fun mapToSetUserData(userPersonalData: UserPersonalData) =
    UserDataForRegistration(
        password = userPersonalData.password,
        userName = userPersonalData.userName,
        mobileNumber = userPersonalData.mobileNumber,
        email = userPersonalData.email
    )