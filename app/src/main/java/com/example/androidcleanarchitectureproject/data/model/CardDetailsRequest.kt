package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardDetailsRequest(
    @Expose
    @SerializedName("amount")
    var amount: String="",

    @Expose
    @SerializedName("clientCode")
    var clientCode: String="",

    @Expose
    @SerializedName("countryCode")
    var countryCode: String="",

    @Expose
    @SerializedName("crediCardNumber")
    var creditCardNumber: String="",

    @Expose
    @SerializedName("currency")
    var currency: String="",

    @Expose
    @SerializedName("cvv")
    var cvv: String="",

    @Expose
    @SerializedName("expiryMonth")
    var expiryMonth: String="",

    @Expose
    @SerializedName("expiryYear")
    var expiryYear: String="",

    @Expose
    @SerializedName("nameOnCard")
    var nameOnCard: String="",

    @Expose
    @SerializedName("refNo")
    var refNo: String="",

    @Expose
    @SerializedName("transType")
    var transType: String=""

)