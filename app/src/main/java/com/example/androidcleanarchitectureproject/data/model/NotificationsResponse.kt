package com.example.myapplication.data.model.api

//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class NotificationsResponse(
//    @Expose
//    @SerializedName("code")
    var code: BigDecimal? = null,
//
//    @Expose
//    @SerializedName("title")
    var title: String? = null,

//    @Expose
//    @SerializedName("clientCode")
    var clientCode: BigDecimal? = null,
//
//    @Expose
//    @SerializedName("dateCreated")
    var dateCreated: String? = null,

//    @Expose
//    @SerializedName("dateRead")
    var dateRead: String? = null,

//    @Expose
//    @SerializedName("dateSent")
    var dateSent: String? = null,

//    @Expose
//    @SerializedName("delivered")
    var delivered: String? = null,

//    @Expose
//    @SerializedName("message")
    var message: String? = null,
//
//    @Expose
//    @SerializedName("mode")
    var mode: String? = null,

//    @Expose
//    @SerializedName("read")
    var read: String? = null,

//    @Expose
//    @SerializedName("refNumber")
    var refNumber: String? = null,

//    @Expose
//    @SerializedName("elaspedTime")
    var elaspedTime: String? = null,

//    @Expose
//    @SerializedName("subject")
    var subject: String? = null,

//    @Expose
//    @SerializedName("decodeCode")
    var decodeCode: String? = null
)
