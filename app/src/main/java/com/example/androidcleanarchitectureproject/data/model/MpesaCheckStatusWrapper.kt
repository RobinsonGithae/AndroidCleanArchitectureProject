package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MpesaCheckStatusWrapper(
    @Expose
    @SerializedName("mpesaCode")
    var mpesaCode: String?,

    @Expose
    @SerializedName("agentCode")
    var agentCode: String?,

    @Expose
    @SerializedName("quoteNo")
    var quoteNo: String?,

    @Expose
    @SerializedName("amount")
    var amount: String?,

    @Expose
    @SerializedName("clientName")
    var clientName: String?,

    @Expose
    @SerializedName("phoneNumber")
    var phoneNumber: String?
)
