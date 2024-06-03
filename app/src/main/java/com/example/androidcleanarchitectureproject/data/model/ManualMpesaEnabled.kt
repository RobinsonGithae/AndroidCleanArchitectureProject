package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ManualMpesaEnabled(
    @Expose
    @SerializedName("enabled")
    var enabled: Boolean=false,

    @Expose
    @SerializedName("mpesaLimit")
    var mpesaLimit: String="",

    @Expose
    @SerializedName("dialogDetails")
    var dialogDetails: String="",

    @Expose
    @SerializedName("overlayDetails")
    var overlayDetails: String=""
)
