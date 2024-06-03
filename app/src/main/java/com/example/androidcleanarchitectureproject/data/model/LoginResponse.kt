package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class LoginResponse(
    @Expose
    @SerializedName("access_token")
    val accessToken: String?,

    @Expose
    @SerializedName("fb_profile_pic_url")
    val fbProfilePicUrl: String?,

    @Expose
    @SerializedName("google_profile_pic_url")
    val googleProfilePicUrl: String?,

    @Expose
    @SerializedName("message")
    val message: String?,

    @Expose
    @SerializedName("server_profile_pic_url")
    val serverProfilePicUrl: String?,

    @Expose
    @SerializedName("status_code")
    val statusCode: String?,

    @Expose
    @SerializedName("email")
    val userEmail: String?,

    @Expose
    @SerializedName("user_id")
    val userId: BigDecimal?,

    @Expose
    @SerializedName("user_name")
    val userName: String?
)