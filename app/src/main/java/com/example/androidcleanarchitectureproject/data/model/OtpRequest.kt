package com.example.androidcleanarchitectureproject.data.model

//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName

data class OtpRequest(
//    @Expose
//    @SerializedName("phoneNumber")
    var phoneNumber: String = "",

//    @Expose
//    @SerializedName("resetCode")
    var resetCode: String = "",

//    @Expose
//    @SerializedName("password")
    var password: String = ""
)
