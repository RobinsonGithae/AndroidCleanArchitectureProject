package com.example.androidcleanarchitectureproject.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.example.androidcleanarchitectureproject.data.manager.DataManager
import com.example.androidcleanarchitectureproject.di.module.PreferenceInfo

import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppPreferencesHelper  @Inject constructor(@ApplicationContext context: Context, @PreferenceInfo prefFileName: String)  :
    PreferencesHelper {



    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)







    override fun getInsuranceQuote(): String? {
        return mPrefs!!.getString(PREF_KEY_INSURANCE_QUOTE, null)
    }

    override fun setInsuranceQuote(insuranceQuote: String?) {
        mPrefs!!.edit().putString(PREF_KEY_INSURANCE_QUOTE, insuranceQuote).apply()
    }

    override fun getUUID(): String? {
        return mPrefs!!.getString(PREF_KEY_UNIQUE_ID, null)
    }

    override fun setUUID(UUID: String?) {
        mPrefs!!.edit().putString(PREF_KEY_UNIQUE_ID, UUID).apply()
    }

    override fun getCurrentUserEmail(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_USER_EMAIL, null)
    }

    override fun setCurrentUserEmail(email: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply()
    }

    override fun getCurrentUserMobileNumber(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_USER_MOBILE_NUMBER, null)
    }

    override fun setCurrentUserMobileNumber(mobileNumber: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_USER_MOBILE_NUMBER, mobileNumber).apply()
    }

    override fun getCurrentUserId(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_USER_ID, null)
    }

    override fun setCurrentUserId(userId: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply()
    }

    override fun getCurrentUserLoggedInMode(): Int {
        return mPrefs!!.getInt(
            PREF_KEY_USER_LOGGED_IN_MODE,
            DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
        )
    }

    override fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode?) {
        if (mode != null) {
            mPrefs!!.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type).apply()
        }
    }

    override fun setCurrentClientId(clientId: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_CLIENT_ID, clientId).apply()
    }

    override fun getCurrentClientId(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_CLIENT_ID, null)
    }

    override fun getCurrentUserName(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_USER_NAME, null)
    }

    override fun setCurrentUserName(userName: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply()
    }

    override fun getCurrentUserProfilePicUrl(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null)
    }


    override fun setCurrentMobileNumberPayingWithMpesa(mobileNumber: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_MOBILE_NUMBER_PAYING_MPESA, mobileNumber).apply()
    }


    override fun getCurrentMobileNumberPayingWithMpesa(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_MOBILE_NUMBER_PAYING_MPESA, null)
    }
















    override fun setCurrentAmountToBePaid(amount: String?) {
        mPrefs!!.edit().putString(PREF_KEY_CURRENT_AMOUNT_TO_BE_PAID, amount).apply()
    }


    override fun getCurrentAmountToBePaid(): String? {
        return mPrefs!!.getString(PREF_KEY_CURRENT_AMOUNT_TO_BE_PAID, null)
    }







    override fun setFullNameOfCurrentUser(fullName: String?) {
        mPrefs!!.edit().putString(PREF_KEY_FULL_NAME_OF_CURRENT_USER, fullName).apply()
    }


    override fun getFullNameOfCurrentUser(): String? {
        return mPrefs!!.getString(PREF_KEY_FULL_NAME_OF_CURRENT_USER, null)
    }










    override fun setIsUserLoggedIn(isUserLoggedIn: Boolean?) {
        if (isUserLoggedIn!=null) {
            mPrefs!!.edit().putBoolean(PREF_KEY_IS_USER_LOGGED_IN, isUserLoggedIn).apply()
        }
    }


    override fun getIsUserLoggedIn(): Boolean? {
        return mPrefs!!.getBoolean(PREF_KEY_IS_USER_LOGGED_IN, false)
    }














    override fun clearAllPreferences(){
        mPrefs.edit().clear().apply()
    }









    companion object {

        private const val PREF_KEY_UNIQUE_ID = "PREF_KEY_UNIQUE_ID"

        private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"

        private const val PREF_KEY_CURRENT_USER_MOBILE_NUMBER = "PREF_KEY_CURRENT_USER_MOBILE_NUMBER"

        private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"

        private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"

        private const val PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL"

        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"

        private const val PREF_KEY_INSURANCE_QUOTE = "PREF_KEY_INSURANCE_QUOTE"

        private const val PREF_KEY_CURRENT_CLIENT_ID = "PREF_KEY_CURRENT_CLIENT_ID"

        private const val PREF_KEY_CURRENT_MOBILE_NUMBER_PAYING_MPESA = "PREF_KEY_CURRENT_MOBILE_NUMBER_PAYING_MPESA"

        private const val  PREF_KEY_CURRENT_AMOUNT_TO_BE_PAID="PREF_KEY_CURRENT_AMOUNT_TO_BE_PAID"

        private const val  PREF_KEY_FULL_NAME_OF_CURRENT_USER="PREF_KEY_FULL_NAME_OF_CURRENT_USER"

        private const val PREF_KEY_IS_USER_LOGGED_IN="PREF_KEY_IS_USER_LOGGED_IN"


        private val mPrefs: SharedPreferences? = null

    }




}