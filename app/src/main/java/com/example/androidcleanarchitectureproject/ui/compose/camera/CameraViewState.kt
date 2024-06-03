package com.example.androidcleanarchitectureproject.ui.compose.camera

import android.net.Uri

data class CameraViewState(

    var passedClaimNumber:String="",

    var claimsFetchErrorInfo:String="",

    var isUserClickedSaveIcon: Boolean=false,
    var isUserClickRetakePhotoIcon: Boolean=false,
    var capturedImageUri: Uri= Uri.EMPTY,

    var isError:Boolean=false


)