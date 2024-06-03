package com.example.androidcleanarchitectureproject.data.prefs


import com.example.androidcleanarchitectureproject.data.manager.DataManager

interface PreferencesHelper {

    fun getCurrentUserEmail(): String?

    fun setUUID(UUID: String?)

    fun getUUID(): String?

    fun setCurrentUserEmail(email: String?)

    fun getCurrentUserMobileNumber(): String?

    fun setInsuranceQuote(insuranceQuote: String?)

    fun getInsuranceQuote(): String?

    fun setCurrentUserMobileNumber(mobileNumber: String?)

    fun getCurrentUserId(): String?

    fun setCurrentUserId(userId: String?)

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode?)

    fun setCurrentClientId(clientId: String?)

    fun getCurrentClientId(): String?

    fun getCurrentUserName(): String?

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserProfilePicUrl(): String?

    fun setCurrentMobileNumberPayingWithMpesa(mobileNumber: String?)
    fun getCurrentMobileNumberPayingWithMpesa(): String?


    fun setCurrentAmountToBePaid(amount: String?)
    fun getCurrentAmountToBePaid(): String?


    fun setFullNameOfCurrentUser(fullName: String?)
    fun getFullNameOfCurrentUser(): String?


    fun setIsUserLoggedIn(isUserLoggedIn: Boolean?)
    fun getIsUserLoggedIn(): Boolean?



    fun clearAllPreferences()

}