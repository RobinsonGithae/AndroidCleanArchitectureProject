package com.example.androidcleanarchitectureproject.data.remote.helper



import com.example.androidcleanarchitectureproject.data.model.AnswerVerify
import com.example.androidcleanarchitectureproject.data.remote.endpoint.ApiEndPoint
import com.example.androidcleanarchitectureproject.data.model.CardDetailsRequest
import com.example.androidcleanarchitectureproject.data.model.ClientDetailResponse
import com.example.androidcleanarchitectureproject.data.model.CredentialsUpdate
import com.example.myapplication.data.model.api.CardDetailsResponse
import com.example.androidcleanarchitectureproject.data.model.DataWrapper
import com.example.androidcleanarchitectureproject.data.model.LoginUserRequest
import com.example.androidcleanarchitectureproject.data.model.ManualMpesaEnabled
import com.example.androidcleanarchitectureproject.data.model.MpesaCheckStatusResponse
import com.example.androidcleanarchitectureproject.data.model.MpesaRequest
import com.example.androidcleanarchitectureproject.data.model.MpesaResponse
import com.example.myapplication.data.model.api.NotificationsResponse
import com.example.myapplication.data.model.api.NotificationsWrapper
import com.example.androidcleanarchitectureproject.data.model.OtpRequest
import com.example.androidcleanarchitectureproject.data.model.SecurityQuestions
import com.example.androidcleanarchitectureproject.data.model.SimpleOtpRequest
import com.example.androidcleanarchitectureproject.data.model.TokenResponse
import com.example.myapplication.data.model.api.UploadAttachmentList
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import java.math.BigDecimal


interface ApiHelper {


    //Request otp

    @POST(ApiEndPoint.ENDPOINT_SERVER_REQUEST_OTP)
    suspend fun getOTP(
        @Body loginRequest: LoginUserRequest

    ): DataWrapper


    //verify OTP
    @POST(ApiEndPoint.ENDPOINT_SERVER_VERIFY_OTP)
    suspend fun verifyOTP(

        @Body
        otpRequest: OtpRequest,

        ): TokenResponse




    //INBOX
    @POST(ApiEndPoint.ENDPOINT_GET_NOTIFICATIONS)
    suspend fun getAllNotifications(
        @Header("Authorization")
        authorization: String,

        @Body
        newNotificationsWrapper: NotificationsWrapper

    ): List<NotificationsResponse>


    //request otp during sign Up and //resend otp
    @POST(ApiEndPoint.ENDPOINT_SIMPLE_OTP_REQUEST)
    suspend fun requestSimpleOTP(
        @Body
        wrapper: DataWrapper,

        @Header("operationType")
        operationType: String,

        @Header("emailAddress")
        emailAddress: String

    ): Boolean


    //Forgot password Screen continue with mobile number
    @POST(ApiEndPoint.ENDPOINT_GET_MY_QUESTIONS)
    suspend fun getQuestionByMobile(

        @Body
        wrapper: DataWrapper

    ): SecurityQuestions


    //send Security question answer for verification
    @POST(ApiEndPoint.ENDPOINT_VERIFY_ANSWER)
    suspend fun getVerifyAnswer(
        @Body
        answerVerify: AnswerVerify

    ): Boolean


    @POST(ApiEndPoint.ENDPOINT_SERVER_CLIENT_INFO)
    suspend fun getClientDetailMod(
        @Body
        token: DataWrapper,

        @Header("Authorization")
        authorizationHeader: String

    ): ClientDetailResponse


    //signup otp validation
    @POST(ApiEndPoint.ENDPOINT_SIMPLE_OTP_VALIDATION)
    suspend fun verifySimpleOTP(
        @Body
        otpRequest: SimpleOtpRequest

    ): Boolean


    // get/ fetch all security questions After create password screen
    @GET(ApiEndPoint.ENDPOINT_GET_QUESTIONS)
    suspend fun getAllQuestions(

    ): List<SecurityQuestions>




    //reset password of client
    @POST(ApiEndPoint.ENDPOINT_UPDATE_CREDENTIALS)
    suspend fun updateCredentials(
        @Body
        credentialsUpdate: CredentialsUpdate

    ): Boolean







    //upload docs,
    @POST(ApiEndPoint.ENDPOINT_UPLOAD_DOCUMENTS)
    suspend fun uploadDocuments(
        @Header("Authorization")
        authorization:String,

        @Header("user")
        userId: String,

        @Header("uuid")
        uuid:String,

        @Body
        uploadAttachmentList: UploadAttachmentList,

    ): Boolean






    //save a quote
    @FormUrlEncoded
    @POST(ApiEndPoint.ENDPOINT_SAVE_QUOTE)
    suspend fun saveQuote(

        @Header("Authorization")
        authorization:String,

        @Header("user")
        user:String,


        @Header("uuid")
        uuid:String,


        @Field("action")
        action: String,


        @Field("quoteCode")
        quoteCode: BigDecimal


        ): Boolean







    //Paying with card
    @POST(ApiEndPoint.ENDPOINT_CARD_PAYMENT)
    suspend fun paymentCard(

        @Header("Authorization")
        authorization:String,

        @Body
        cardDetailsRequest: CardDetailsRequest

        ): CardDetailsResponse



    //fetch mpesa payment setup details/information
    @GET(ApiEndPoint.ENDPOINT_CHECK_MPESA_MODE)
    suspend fun getMpesaEnabledPaymentOptions(

        @Header("Authorization")
        authorization:String,


        ): ManualMpesaEnabled




    //process stk push
    @POST(ApiEndPoint.ENDPOINT_MPESA_PAYMENT)
    suspend fun mpesaPayment(

        @Header("Authorization")
        authorization:String,

        @Header("user")
        user:String,

        @Header("uuid")
        uuid:String,


        @Body
        mpesaRequest: MpesaRequest

    ): MpesaResponse




    suspend fun doLogoutApiCall(): ResponseBody?












//check mpesa stk payment status
@GET(ApiEndPoint.ENDPOINT_MPESA_PAYMENT_VERIFICATION)
    suspend fun verifyMpesaPayment(

    @Header("Authorization")
    authorization:String,

    @Header("user")
    user:String,


    @Header("uuid")
    uuid:String,


    @Query("CheckoutRequestID")
    checkoutRequestID:String,

    @Query("agentCode")
    agentCode: String

    ): MpesaCheckStatusResponse


}