package com.example.androidcleanarchitectureproject.ui.compose.card_payment

import com.example.androidcleanarchitectureproject.data.model.ApiError
import com.example.myapplication.data.model.api.CardDetailsResponse


data class CardPaymentViewState(

    val months:List<String> = listOf("01", "02", "03","04","05","06","07","08","09","10","11","12"),
    var years:List<String> = emptyList(),

    //var monthSelected:String="",

    var showErrorDialog:Boolean=false,

    var showMonthsDialog:Boolean=false,
    var showYearsDialog:Boolean=false,

    var doValidation:Boolean=false,

    var quoteNumberOfCurrentlySelectedQuote:String="",

    val transType:String="NB",
    var cardPaymentAmount:String="",
    var clientCode:String="",
    var countryCode:String="254",
    var currencyCode:String="KES",


    //card details
    var nameOnCard:String="",
    var cardNumber:String="",
    var cardExpiryMonth:String="",
    var cardExpiryYear:String="",
    var cardCvvNumber:String="",

    var isPayNowClicked:Boolean=false,


    //validation checks
    //valid checks
    var isNameOnCardValid:Boolean=false,
    var isCardNumberValid:Boolean=false,
    var isCardExpiryMonthValid:Boolean=false,
    var isCardExpiryYearValid:Boolean=false,
    var isCardCvvNumberValid:Boolean=false,


    //invalid checks
    var isNameOnCardInvalid:Boolean=false,
    var isCardNumberInvalid:Boolean=false,
    var isCardExpiryMonthInvalid:Boolean=false,
    var isCardExpiryYearInvalid:Boolean=false,
    var isCardCvvNumberInvalid:Boolean=false,

    //empty checks
    var isNameOnCardEmpty:Boolean=false,
    var isCardNumberEmpty:Boolean=false,
    var isCardExpiryMonthEmpty:Boolean=false,
    var isCardExpiryYearEmpty:Boolean=false,
    var isCardCvvNumberEmpty:Boolean=false,


    // var isShowExpiryYearDialog:Boolean=false,


    // click updates



    var wasPayNowButtonClickedByUser:Boolean=false,


    //api states
    var claimsFetchErrorInfo:String="",
    //in case of error
    var apiError: ApiError?= ApiError(),

    var claimFetchApiErrorInfo:String="",

    //api api call status
    var isProcessCardPaymentApiLoading: Boolean = false,
    var isProcessCardPaymentApiError: Boolean = false,
    var isProcessCardPaymentApiSuccess: Boolean = false,


    var isConvertToPolicyApiLoading: Boolean = false,
    var isConvertToPolicyApiError: Boolean = false,
    var isConvertToPolicyApiSuccess: Boolean = false,





    var isUserClickedPayNowButton: Boolean = false,

    //data from payment api
    var cardDetailsResponseAfterPayment: CardDetailsResponse = CardDetailsResponse(),


    var isUpdateYears: Boolean =false,



    )