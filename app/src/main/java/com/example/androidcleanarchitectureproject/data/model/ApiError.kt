package com.example.androidcleanarchitectureproject.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiError(
    @Expose
    @SerializedName("status")
    var status: String="",

    @Expose
    @SerializedName("errorType")
    var errorType: String="",

    @Expose
    @SerializedName("message")
    var message: String=""
)