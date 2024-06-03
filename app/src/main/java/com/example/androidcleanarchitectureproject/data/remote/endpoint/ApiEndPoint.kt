package com.example.androidcleanarchitectureproject.data.remote.endpoint

object ApiEndPoint {

    const val ENDPOINT_SERVER_VERIFY_OTP: String = "auth-service/api/auth/validateLoginOTP"

    const val ENDPOINT_SERVER_REQUEST_OTP: String =  "auth-service/api/auth/sendOtp"

    const val ENDPOINT_MPESA_PAYMENT: String = "payments-service/api/payment/mpesa/process-stk-push"

    const val ENDPOINT_CHECK_MPESA_MODE: String = "document-service/api/setups/mpesa-manual-payment"

    const val ENDPOINT_MPESA_PAYMENT_VERIFICATION: String = "payments-service/api/payment/mpesa/stkCheckStatus"

    const val ENDPOINT_CARD_PAYMENT: String = "payments-service/api/payment/processCardPayment"

    const val ENDPOINT_SERVER_CLIENT_INFO: String = "auth-service/api/auth/getDetailsByCode"

    const val ENDPOINT_SIMPLE_OTP_VALIDATION: String = "auth-service/api/auth/validateOneTimePin"

    const val ENDPOINT_SIMPLE_OTP_REQUEST: String = "auth-service/api/auth/sendOneTimePinSms"

    const val ENDPOINT_GET_QUESTIONS: String = "auth-service/api/auth/getAllQuestions"

    const val ENDPOINT_GET_MY_QUESTIONS: String = "auth-service/api/auth/getClientQuestions"

    const val ENDPOINT_GET_NOTIFICATIONS: String = "notification-service/api/auth/getClientNotifications"

    const val ENDPOINT_VERIFY_ANSWER: String = "auth-service/api/auth/validateSecurityQuestion"

    const val ENDPOINT_UPLOAD_DOCUMENTS: String = "document-service/api/docs/uploadDocuments"

    const val ENDPOINT_SAVE_QUOTE: String = "quotation-service/api/quotation/saveClientWebQuote"

    const val ENDPOINT_UPDATE_CREDENTIALS: String = "auth-service/api/auth/updateClientPassword"

}