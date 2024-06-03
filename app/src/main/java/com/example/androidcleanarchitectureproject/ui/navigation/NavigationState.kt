package com.example.myapplication.ui.compose.navigation

data class NavigationState(

    var isUserLoggedIn:Boolean=false,
    var isLunchDashboardAsStartDestination:Boolean=false,

    var accessToken:String="hello"

)
