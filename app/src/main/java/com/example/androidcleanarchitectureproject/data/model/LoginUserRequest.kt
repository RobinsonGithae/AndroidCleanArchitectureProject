package com.example.androidcleanarchitectureproject.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginUserRequest(
    @Expose
    @SerializedName("username")

    var username: String ="",

    @Expose
    @SerializedName("password")

    var password: String =""
)
