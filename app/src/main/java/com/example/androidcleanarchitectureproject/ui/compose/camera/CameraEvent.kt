package com.example.androidcleanarchitectureproject.ui.compose.camera

import android.net.Uri

sealed class CameraEvent {
    data class OnUpdateIsUserClickedSaveIcon(var isUserClickedSaveIcon: Boolean) : CameraEvent()
    data class OnUpdateIsUserClickRetakePhotoIcon(var isUserClickRetakePhotoIcon: Boolean) : CameraEvent()
    data class OnUpdateCapturedImageUri(var capturedImageUri: Uri) : CameraEvent()
    data class OnUpdateIsError (var isError:Boolean): CameraEvent()
    object OnClickSaveIcon: CameraEvent()
    object OnClickRetakePhotoIcon: CameraEvent()
    object DoInitialTasksUponLaunch: CameraEvent()
    object OnOtherListingEvent: CameraEvent()

}