package com.example.androidcleanarchitectureproject.data.remote.helper

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
import com.example.myapplication.data.model.api.CardDetailsResponse
import com.example.myapplication.data.model.api.NotificationsResponse
import com.example.myapplication.data.model.api.NotificationsWrapper
import com.example.myapplication.data.model.api.UploadAttachmentList
import okhttp3.ResponseBody
import java.math.BigDecimal

class AppApiHelper : ApiHelper {


    override suspend fun doLogoutApiCall(): ResponseBody? {
        TODO("Not yet implemented")
    }


    override suspend fun getClientDetailMod(token: DataWrapper, authorizationHeader:String): ClientDetailResponse {
        TODO("Not yet implemented")
    }




//    override suspend fun verifyOTP(otpRequest: OtpRequest?, device: String?): TokenResponse? {
//        TODO("Not yet implemented")
//    }



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




    override suspend fun uploadDocuments(authorization: String, userId: String, uuid: String, uploadAttachmentList: UploadAttachmentList): Boolean {
        TODO("Not yet implemented")
    }




    override suspend fun mpesaPayment(authorization: String, user: String,uuid: String, mpesaRequest: MpesaRequest): MpesaResponse {
        TODO("Not yet implemented")
    }



    override suspend fun saveQuote(authorization:String, user: String,uuid: String, action:String,quoteCode: BigDecimal): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun paymentCard(authorization: String, cardDetailsRequest: CardDetailsRequest): CardDetailsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun verifyMpesaPayment(
        authorization: String,
        user: String,
        uuid: String,

        checkoutRequestID: String,
        agentCode: String
    ): MpesaCheckStatusResponse {
        TODO("Not yet implemented")
    }







    override suspend fun getAllNotifications(authorization: String, newNotificationsWrapper: NotificationsWrapper): List<NotificationsResponse> {

        //takes in params -  clientCode: String, status: String? from model
        TODO("Not yet implemented")
    }



    override suspend fun requestSimpleOTP(
        wrapper: DataWrapper,
        operationType: String,
        email: String
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun verifySimpleOTP(otpRequest: SimpleOtpRequest): Boolean{
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






}
