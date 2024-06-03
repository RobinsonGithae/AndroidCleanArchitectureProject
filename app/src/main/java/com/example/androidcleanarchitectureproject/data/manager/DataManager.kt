package com.example.androidcleanarchitectureproject.data.manager

import com.example.androidcleanarchitectureproject.data.prefs.PreferencesHelper
import com.example.androidcleanarchitectureproject.data.remote.helper.ApiHelper


interface DataManager  : PreferencesHelper, ApiHelper {



    fun setUserAsLoggedOut()

    fun updateApiHeader(userId: String?, accessToken: String?, uuid: String?)

    fun updateProtectedLoginApiHeader(uuid: String?)


    fun updateUserInfo(
        accessToken: String?,
        userId: String?,
        loggedInMode: LoggedInMode?,
        userName: String?,
        mobileNumber: String?,
        clientId: String?,
        email: String?,
        uuid: String?
    )


    enum class LoggedInMode(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1)

    }


}