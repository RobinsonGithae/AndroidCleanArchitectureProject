package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MpesaResponse(
    @Expose
    @SerializedName("ResponseCode")
    var responseCode: String="",

    @Expose
    @SerializedName("ResponseDescription")
    var responseDescription: String="",

    @Expose
    @SerializedName("MerchantRequestID")
    var merchantRequestID: String="",

    @Expose
    @SerializedName("CheckoutRequestID")
    var checkoutRequestID: String="",

    @Expose
    @SerializedName("transCode")
    var transCode: String="",

    @Expose
    @SerializedName("message")
    var message: String=""
)
