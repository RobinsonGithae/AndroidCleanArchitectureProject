package com.example.myapplication.ui.compose.navigation


sealed class NavigationEvent {
    data class OnUpdateIsUserLoggedIn(var isUserLoggedIn: Boolean) : NavigationEvent()
    data class OnUpdateDashboardScreenAsStartDestination(var isLaunchDashboardAsStartDestination: Boolean) : NavigationEvent()

    data class OnUpdateAccessToken(var accessToken: String) : NavigationEvent()




    object OnOtherEvent: NavigationEvent()

}
