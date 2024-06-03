package com.example.androidcleanarchitectureproject.ui.navigation


import android.util.Log
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidcleanarchitectureproject.ui.compose.camera.CameraScreen
import com.example.androidcleanarchitectureproject.ui.compose.card_payment.PayWithCardActivityScreen
import com.example.myapplication.ui.compose.navigation.NavigationEvent
import com.example.myapplication.ui.compose.navigation.NavigationViewModel
import kotlinx.coroutines.CoroutineScope
import java.io.File
import java.util.concurrent.ExecutorService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nav(
   // navController: NavHostController,
    //  onEvent: (LoginEvent) -> Unit,

    onUpdateKeepSplashScreenOpenUntilWhenNavIsLoaded:(Boolean)->Unit,

    viewModel: NavigationViewModel,
    cardPaymentViewModel: CardPaymentViewModel,

    ) {


    val navState=viewModel.navigationState

    val navController = rememberNavController()





    val scopeForNavDrawerMainScreen: CoroutineScope = rememberCoroutineScope()
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)





    //login initializations
    var loginState = State3()
    val otpViewState = OtpViewState()

    val statePasswordReset = ResetPasswordViewState()






    val onUpdatePhoneNumber: (String) -> Unit = {}
    val onUpdatePinPassword: (String) -> Unit = {}
    val onUpdateIsPhoneNumberValid: (Boolean) -> Unit = {}
    val onUpdateIsPinPasswordValid: (Boolean) -> Unit = {}
    val onNavigateUp = { /*TODO*/ }
    val onError: (Boolean) -> Unit = {

        /*TODO*/
    }
    val onClickLogin: (LoginEvent.onClickLoginButton) -> Unit = {}
    val onClickRegister: (LoginEvent.onClickReisterHere) -> Unit = {}
    val onClickForgotPassword: (LoginEvent.onClickForgotYourPin) -> Unit = {}


    //register Initializations

    val registerState = RegisterViewState()
    val onUpdateSurname: (String) -> Unit = {}

    val onUpdateFirstName: (String) -> Unit = {}

    val onUpdateMobileNumber: (String) -> Unit = {}
    val onUpdateEmailAddress: (String) -> Unit = {}
    val onUpdateEnteredPin: (String) -> Unit = {}
    val onUpdateConfirmedPin: (String) -> Unit = {}
    val onUpdateAttachedDocument: (String) -> Unit = {}

    val onClickRegisterButton: (RegisterEvent.OnClickRegisterButton) -> Unit = {}

    val onClickAttachButton: (RegisterEvent.OnClickRegisterButton) -> Unit = {}



    val forgotPasswordState=ForgotPasswordViewState()


    val securityQuestionState=SecurityQuestionViewState()

    //val loginViewModel:LoginViewModel= viewModel()




    //DashboardScreenViewModelInitializations - use hilt to initialize

    val homePageViewModel: HomePageViewModel = hiltViewModel()

    val policyListingViewModel: PolicyListingViewModel= hiltViewModel()
    val policyListingViewState=policyListingViewModel.policyListingState

    val inboxViewModel: InboxViewModel= hiltViewModel()

    val claimsViewModel: ClaimsViewModel= hiltViewModel()
    val claimsViewState:ClaimsViewState=claimsViewModel.claimsState


    val policyDetailViewModel:PolicyDetailsViewModel= hiltViewModel()

    val quoteDetailViewModel: QuoteDetailsViewModel = hiltViewModel()

    val vehicleDetailsViewModel: VehicleDetailsViewModel = hiltViewModel()

   // val sharedPolicyListingAndDetailsViewModel:PolicyListingAndDetailsSharedViewModel= hiltViewModel()

    //val sharedViewModel= hiltViewModel<PolicyListingAndDetailsSharedViewModel>()

    val sharedViewModel:PolicyListingAndDetailsSharedViewModel= hiltViewModel()

    val yourProfileViewModel:YourProfileViewModel= hiltViewModel()


    val vehicleValuationViewModel: VehicleValuationViewModel = hiltViewModel()

    val contactUsViewModel: ContactUsViewModel = hiltViewModel()

    val computePremiumViewModel:ComputePremiumViewModel= hiltViewModel()

    val proofOfOwnershipViewModel: ProofOfOwnershipViewModel = hiltViewModel()

    val cameraViewModel: CameraViewModel = hiltViewModel()

    val identificationDocumentViewModel: IdentificationDocumentViewModel = hiltViewModel()


    val cardPaymentViewModelTrial: CardPaymentViewModel = hiltViewModel()

    val stickerPickupViewModel: StickerPickupViewModel = hiltViewModel()

    val paymentSuccessfulViewModel: PaymentSuccessfulViewModel = hiltViewModel()



    val mpesaPaymentViewModel:MpesaPaymentViewModel= hiltViewModel()




    val confirmAndPayViewModel: ConfirmAndPayViewModel = hiltViewModel()





    //camera screen inits
     lateinit var outputDirectory: File
     lateinit var cameraExecutor: ExecutorService
     var shouldShowCamera by remember { mutableStateOf(false) }



    var routeOfLastVisitedScreen by rememberSaveable { mutableStateOf("DashboardScreenFour") }


    LaunchedEffect(Unit){

        onUpdateKeepSplashScreenOpenUntilWhenNavIsLoaded(false)
    }







    NavHost(navController = navController, startDestination = if(navState.isLunchDashboardAsStartDestination){ routeOfLastVisitedScreen } else{ "SplashScreen"}) {





        composable(route = "SplashScreen") {

            LaunchedEffect(Unit){
                //check if user is logged in and update state upon launch
                //first check from shared preference whether user is logged in.
                if (viewModel.dataManager.getIsUserLoggedIn()==true) {
                    viewModel.onEvent(NavigationEvent.OnUpdateIsUserLoggedIn(true))
                } //else{viewModel.onEvent(NavigationEvent.OnUpdateIsUserLoggedIn(false))}
            }

            SplashScreen(viewModel.navigationState, navController)
        }

        composable(route = "LoginScreen") {

            LaunchedEffect(Unit){
                //if login screen is launched log out user with api as well as update shared pref for login
                viewModel.logoutUser()
                viewModel.onEvent(NavigationEvent.OnUpdateIsUserLoggedIn(false))
            }




            LoginScreenContent(
                loginState,
                {},
                onUpdatePhoneNumber,
                onUpdatePinPassword,
                onClickLogin,
                onUpdateIsPhoneNumberValid,
                onUpdateIsPinPasswordValid,
                {}, {},{},{}, {}, {}, {}, {},
                onNavigateUp,
                onError,
                {},
                onClickRegister,
                onClickForgotPassword,
                navController

            )


        }


        composable(route = "CameraScreen") {
           // CameraScreen(outputDirectory, cameraExecutor, {}, {}, navController)

            CameraScreen(outputDirectory, cameraExecutor, {}, {}, navController, cameraViewModel)
        }

        composable(route = "CardPaymentScreen") {

         PayWithCardActivityScreen(cardPaymentViewModelTrial,quoteDetailViewModel,navController)
        }

        composable(route = "PaymentScreen") {
            PaymentScreen(navController)
        }

        composable(route = "PendingPaymentScreen") {
            PendingPaymentScreen(mpesaPaymentViewModel,quoteDetailViewModel,navController)
        }

        composable(route = "SecurityQuestionScreen") {
            SecurityQuestionScreenContent(securityQuestionState, {}, {},{},{},{}, {},{}, {}, {}, navController)
        }

        composable(route = "StkPushAwaitingScreen") {
            StkPushAwaitingScreen(navController)
        }



    }
}