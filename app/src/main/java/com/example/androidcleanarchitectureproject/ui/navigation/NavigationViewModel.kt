package com.example.myapplication.ui.compose.navigation


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.DataManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NavigationViewModel @Inject constructor(
    val dataManager: DataManager,
) : ViewModel() {


    var navigationState by mutableStateOf(NavigationState())



    init {

     //   updateDashboardScreenAsStartDestination()

    }


    fun updateDashboardScreenAsStartDestination() {

        navigationState=navigationState.copy(
            isLunchDashboardAsStartDestination = true,
        )


        viewModelScope.launch {}

    }


    fun logoutUser(){

    }






    /** onEvent function that accepts event **/
    fun onEvent(event: NavigationEvent) {
        when (event) {

            is NavigationEvent.OnUpdateIsUserLoggedIn -> {
                navigationState = navigationState.copy(
                    isUserLoggedIn = event.isUserLoggedIn,
                    isLunchDashboardAsStartDestination = true
                )
            }


            is NavigationEvent.OnUpdateDashboardScreenAsStartDestination -> {
                navigationState = navigationState.copy(
                    isLunchDashboardAsStartDestination = true
                )

                updateDashboardScreenAsStartDestination()
            }


            is NavigationEvent.OnUpdateAccessToken -> {
                navigationState = navigationState.copy(
                    accessToken = event.accessToken
                )



            }





            else -> {
                NavigationEvent.OnOtherEvent
            }

        }


    }


}