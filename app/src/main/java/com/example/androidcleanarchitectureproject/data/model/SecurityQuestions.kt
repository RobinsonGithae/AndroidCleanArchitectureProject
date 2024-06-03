package com.example.androidcleanarchitectureproject.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SecurityQuestions(
    @Expose
    @SerializedName("code")
    var code: Int=0,

    @Expose
    @SerializedName("description")
    var description: String="Security question?"
)
