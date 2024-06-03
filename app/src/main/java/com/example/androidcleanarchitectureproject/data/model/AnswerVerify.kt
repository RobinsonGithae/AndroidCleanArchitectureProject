package com.example.androidcleanarchitectureproject.data.model

//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName

data class AnswerVerify(
  //  @Expose
  //  @SerialName("securityQuestionCode")
    val securityQuestionCode: Int=0,

//    @Expose
//    @SerializedName("phoneNumber")
    val phoneNumber: String="",

//    @Expose
//    @SerializedName("answer")
    val answer: String=""
)