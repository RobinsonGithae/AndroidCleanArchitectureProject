package com.example.myapplication.data.model.api

//import com.google.gson.annotations.Expose
//import com.google.gson.annotations.SerializedName

data class UploadAttachmentList(
//    @Expose
//    @SerializedName("attachmentList")
    val attachmentList: List<UploadRequest> = emptyList()
)

//{
//    // No need for additional setter, as Kotlin automatically generates one for data classes
//}
