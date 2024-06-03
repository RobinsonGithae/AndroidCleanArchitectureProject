package com.example.androidcleanarchitectureproject.ui.compose.mpesa_payment

import com.example.androidcleanarchitectureproject.data.model.ApiError
import com.example.androidcleanarchitectureproject.data.model.ManualMpesaEnabled
import com.example.androidcleanarchitectureproject.data.model.MpesaCheckStatusResponse
import com.example.androidcleanarchitectureproject.data.model.MpesaResponse


data class MpesaViewState (

 var convertQuoteToPolicy:Boolean=false,


 //to policy conversion
 var isConvertToPolicyApiLoading:Boolean = false,
 var isConvertToPolicyApiError:Boolean = false,
 var isConvertToPolicyApiSuccess:Boolean = false,

 var covertToPolicyApiErrorInfo:String="",






 var apiError: ApiError?= ApiError(),

 var currentQuoteQuoteNumber:String="",
 var currentAmountToBePaid:String="",
 var currentSelectedAgentAgentCode:String="0",







 var isProcessMpesaStkPush:Boolean=false,

 var isUserClickedDoneMpesaButton:Boolean=false,


 var isError:Boolean=false,
 var isLoading :Boolean=false,
 var  isApiLoading :Boolean=false,

    //state to dismiss the error dialog
 var showIsApiErrorDialog:Boolean=false,



    //MPESA payment Api states
 var isMpesaPaymentApiLoading:Boolean = false,
 var isMpesaPaymentApiError:Boolean = true,
 var isMpesaPaymentApiSuccess:Boolean = false,
 var mpesaPaymentErrorInfo:String = "",


 var mpesaPaymentResponse: MpesaResponse = MpesaResponse(),




    //fetch  mpesa setup Information
 var isGetMpesaEnabledPaymentOptionsApiLoading:Boolean = false,
 var isGetMpesaEnabledPaymentOptionsApiError:Boolean = false,
 var isGetMpesaEnabledPaymentOptionsApiSuccess:Boolean = false,
 var getMpesaEnabledPaymentOptionsErrorInfo:String = "",



 var isVerifyMpesaPaymentApiLoading:Boolean=false,

 var isVerifyMpesaPaymentApiError:Boolean=false,

 var isVerifyMpesaPaymentApiSuccess: Boolean=false,

 var verifyMpesaPaymentErrorInfo:String="",




 var isGetMpesaPaymentInfoApiLoading:Boolean = false,
 var isGetMpesaPaymentInfoApiError:Boolean = false,
 var isGetMpesaPaymentInfoApiSuccess:Boolean = false,
 var getMpesaPaymentDetailsErrorInfo:String="",

 var mpesaDetails:List<String> = emptyList(),




 var mpesaEnabledPaymentOptionsResponse: ManualMpesaEnabled = ManualMpesaEnabled(),

 var mpesaCheckStatusResponse: MpesaCheckStatusResponse = MpesaCheckStatusResponse(),


 var mobileNumberToReceiveStkPush:String="070000000000",




//







 )