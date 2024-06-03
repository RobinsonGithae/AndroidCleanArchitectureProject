package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class MpesaRequest(
    @Expose
    @SerializedName("phoneNumber")
    var mobileNumber: String="",

    @Expose
    @SerializedName("transactionDesc")
    var transactionDesc: String="",

    @Expose
    @SerializedName("accountReference")
    var accountReference: String="",

    @Expose
    @SerializedName("amount")
    var amount: BigDecimal= BigDecimal(0),

    @Expose
    @SerializedName("transType")
    var transactionType: String="",

    @Expose
    @SerializedName("senderName")
    var senderName: String="",

    @Expose
    @SerializedName("agentCode")
    var agentCode: BigDecimal=BigDecimal(0)
)
