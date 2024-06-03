package com.example.androidcleanarchitectureproject.data.manager

import com.example.androidcleanarchitectureproject.data.model.AnswerVerify
import com.example.androidcleanarchitectureproject.data.model.CardDetailsRequest
import com.example.androidcleanarchitectureproject.data.model.ClientDetailResponse
import com.example.androidcleanarchitectureproject.data.model.CredentialsUpdate
import com.example.androidcleanarchitectureproject.data.model.DataWrapper
import com.example.androidcleanarchitectureproject.data.model.LoginUserRequest
import com.example.androidcleanarchitectureproject.data.model.ManualMpesaEnabled
import com.example.androidcleanarchitectureproject.data.model.MpesaCheckStatusResponse
import com.example.androidcleanarchitectureproject.data.model.MpesaRequest
import com.example.androidcleanarchitectureproject.data.model.MpesaResponse
import com.example.androidcleanarchitectureproject.data.model.OtpRequest
import com.example.androidcleanarchitectureproject.data.model.SecurityQuestions
import com.example.androidcleanarchitectureproject.data.model.SimpleOtpRequest
import com.example.androidcleanarchitectureproject.data.model.TokenResponse
import com.example.androidcleanarchitectureproject.data.prefs.PreferencesHelper
import com.example.myapplication.data.model.api.CardDetailsResponse
import com.example.myapplication.data.model.api.NotificationsResponse
import com.example.myapplication.data.model.api.NotificationsWrapper
import com.example.myapplication.data.model.api.UploadAttachmentList
import okhttp3.ResponseBody
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton


@Singleton

class AppDataManager @Inject constructor(
    private val mPreferencesHelper: PreferencesHelper,
//
//    private val apiHeader: ProtectedApiHeader
) : DataManager {
    override fun setUserAsLoggedOut() {
        TODO("Not yet implemented")
    }

    override fun updateApiHeader(userId: String?, accessToken: String?, uuid: String?) {
        TODO("Not yet implemented")
    }

    override fun updateProtectedLoginApiHeader(uuid: String?) {
        TODO("Not yet implemented")
    }



    override fun updateUserInfo(
        accessToken: String?,
        userId: String?,
        loggedInMode: DataManager.LoggedInMode?,
        userName: String?,
        mobileNumber: String?,
        clientId: String?,
        email: String?,
        uuid: String?
    ) {
        TODO("Not yet implemented")
    }



    override fun getCurrentUserEmail(): String? {

        return mPreferencesHelper.getCurrentUserEmail()
    }

    override fun setUUID(UUID: String?) {
        mPreferencesHelper.setUUID(UUID)
    }

    override fun getUUID(): String? = mPreferencesHelper.getUUID()


    override fun setCurrentUserEmail(email: String?) {
        mPreferencesHelper.setCurrentUserEmail(email)
    }

    override fun getCurrentUserMobileNumber(): String? {


        return mPreferencesHelper.getCurrentUserMobileNumber()
    }

    override fun setInsuranceQuote(insuranceQuote: String?) {
        mPreferencesHelper.setInsuranceQuote(insuranceQuote)
    }

    override fun getInsuranceQuote(): String? {

        return mPreferencesHelper.getInsuranceQuote()
    }

    override fun setCurrentUserMobileNumber(mobileNumber: String?) {

        mPreferencesHelper.setCurrentUserMobileNumber(mobileNumber)
    }

    override fun getCurrentUserId(): String? = mPreferencesHelper.getCurrentUserId()


    override fun setCurrentUserId(userId: String?) {
        mPreferencesHelper.setCurrentUserId(userId)
    }

    override fun getCurrentUserLoggedInMode(): Int = mPreferencesHelper.getCurrentUserLoggedInMode()


    override fun setCurrentUserLoggedInMode(mode: DataManager.LoggedInMode?) {
        TODO("Not yet implemented")
    }

    override fun setCurrentClientId(clientId: String?) {
        mPreferencesHelper.setCurrentClientId(clientId)
    }

    override fun getCurrentClientId(): String? {
        return mPreferencesHelper.getCurrentClientId()

    }

    override fun getCurrentUserName(): String? {

        return mPreferencesHelper.getCurrentUserName()
    }

    override fun setCurrentUserName(userName: String?) {
        mPreferencesHelper.setCurrentUserName(userName)
    }

    override fun getCurrentUserProfilePicUrl(): String? {

        return mPreferencesHelper.getCurrentUserProfilePicUrl()
    }



    override fun setCurrentMobileNumberPayingWithMpesa(mobileNumber: String?) {
        mPreferencesHelper.setCurrentMobileNumberPayingWithMpesa(mobileNumber)
    }

    override fun getCurrentMobileNumberPayingWithMpesa(): String? {
        return mPreferencesHelper.getCurrentMobileNumberPayingWithMpesa()
    }



    override fun setCurrentAmountToBePaid(amount: String?) {
        mPreferencesHelper.setCurrentAmountToBePaid(amount)
    }

    override fun getCurrentAmountToBePaid(): String? {
        return mPreferencesHelper.getCurrentAmountToBePaid()
    }

    override fun setFullNameOfCurrentUser(fullName: String?) {
        mPreferencesHelper.setFullNameOfCurrentUser(fullName)
    }

    override fun getFullNameOfCurrentUser(): String? {
        return mPreferencesHelper.getFullNameOfCurrentUser()
    }



    override fun setIsUserLoggedIn(isUserLoggedIn: Boolean?) {
        mPreferencesHelper.setIsUserLoggedIn(isUserLoggedIn)
    }

    override fun getIsUserLoggedIn(): Boolean? {
        return mPreferencesHelper.getIsUserLoggedIn()
    }


    override suspend fun getOTP(loginRequest: LoginUserRequest): DataWrapper {
        TODO("Not yet implemented")
    }

    override suspend fun verifyOTP(
        otpRequest: OtpRequest,
//        deviceModel: String,
//        deviceLocation: String,
//        deviceType: String,
//        uuid: String,
//        platform: String,
//        os: String
    ): TokenResponse {
        TODO("Not yet implemented")
    }

    override suspend fun doLogoutApiCall(): ResponseBody? {
        TODO("Not yet implemented")
    }



    override suspend fun getClientDetailMod(
        token: DataWrapper,
        authorizationHeader: String
    ): ClientDetailResponse {
        TODO("Not yet implemented")
    }



    override suspend fun uploadDocuments(
        authorization: String,
        userId: String,
        uuid: String,
        uploadAttachmentList: UploadAttachmentList
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun verifyMpesaPayment(authorization:String, user: String, uuid: String,  checkoutRequestID:String, agentCode:String  ): MpesaCheckStatusResponse {
        TODO("Not yet implemented")
    }


    override suspend fun saveQuote(
        authorization: String,
        user: String,
        uuid: String,
        action: String,
        quoteCode: BigDecimal
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun paymentCard(
        authorization: String,
        cardDetailsRequest: CardDetailsRequest
    ): CardDetailsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun mpesaPayment(
        authorization: String,
        user:String,
        uuid:String,
        mpesaRequest: MpesaRequest
    ): MpesaResponse {
        TODO("Not yet implemented")
    }





    override suspend fun getAllNotifications(
        authorization: String,
        newNotificationsWrapper: NotificationsWrapper
    ): List<NotificationsResponse> {
        TODO("Not yet implemented")
    }


    override suspend fun requestSimpleOTP(
        wrapper: DataWrapper,
        operationType: String,
        email: String
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun verifySimpleOTP(otpRequest: SimpleOtpRequest): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getAllQuestions(): List<SecurityQuestions> {
        TODO("Not yet implemented")
    }

    override suspend fun getQuestionByMobile(wrapper: DataWrapper): SecurityQuestions {
        TODO("Not yet implemented")
    }

    override suspend fun updateCredentials(credentialsUpdate: CredentialsUpdate): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getVerifyAnswer(answerVerify: AnswerVerify): Boolean {
        TODO("Not yet implemented")
    }


    override suspend fun getMpesaEnabledPaymentOptions(authorization: String): ManualMpesaEnabled {
        TODO("Not yet implemented")
    }


    override fun clearAllPreferences() {
        mPreferencesHelper.clearAllPreferences()

    }


}