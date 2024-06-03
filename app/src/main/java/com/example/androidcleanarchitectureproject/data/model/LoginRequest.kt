package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
//@Parcelize
//@Serializable
data class LoginRequest (
    var serverLoginRequest: ServerLoginRequest

)


//@Parcelize
//@Serializable
data class ServerLoginRequest(
       @Expose
        @SerializedName("username")
    var username: String="",

        @Expose
        @SerializedName("password")
    var password: String="",

)
