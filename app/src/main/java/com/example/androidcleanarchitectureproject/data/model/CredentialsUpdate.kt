package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CredentialsUpdate(
    @Expose
    @SerializedName("phoneNumber")
    var phoneNumber: String="",

    @Expose
    @SerializedName("password")
    var password: String="",

    @Expose
    @SerializedName("uuid")
    var uuid: String=""
)
