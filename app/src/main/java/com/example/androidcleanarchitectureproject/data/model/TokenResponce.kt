package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class TokenResponse(
    @Expose
    @SerializedName("access_token")
    val accessToken: String = "",

    @Expose
    @SerializedName("token_type")
    val tokenType: String = "",

    @Expose
    @SerializedName("refresh_token")
    val refreshToken: String = "",

    @Expose
    @SerializedName("expires_in")
    val expiresIn: BigDecimal = BigDecimal(0),

    @Expose
    @SerializedName("scope")
    val scope: String = ""
)
