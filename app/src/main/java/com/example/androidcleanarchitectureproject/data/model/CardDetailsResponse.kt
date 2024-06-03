package com.example.myapplication.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CardDetailsResponse(
    @Expose
    @SerializedName("transactionStatus")
    var transactionStatus: String="",

    @Expose
    @SerializedName("authorizationCode")
    var authorizationCode: String="",

    @Expose
    @SerializedName("captureAmount")
    var captureAmount: String="",

    @Expose
    @SerializedName("captureReconciliationId")
    var captureReconciliationId: String="",

    @Expose
    @SerializedName("authReconciliationId")
    var authReconciliationId: String="",

    @Expose
    @SerializedName("requestId")
    var requestId: String=""
)





