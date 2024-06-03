package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataWrapper(
    @Expose
    @SerializedName("value")
    var value: String=""
)
