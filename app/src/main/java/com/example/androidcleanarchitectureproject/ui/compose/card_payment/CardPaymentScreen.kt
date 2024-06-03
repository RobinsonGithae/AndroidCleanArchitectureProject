package com.example.androidcleanarchitectureproject.ui.compose.card_payment

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.EmptyBuildDrawCacheParams.density
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.ui.compose.dialogs.CustomScrollableDialogForMonthAndYearPicking
import com.example.myapplication.ui.compose.dialogs.RequestFailedDialog
import com.example.myapplication.ui.compose.quote_details.QuoteDetailsViewState
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.colorBlack
import com.example.myapplication.ui.theme.colorPrimary
import com.example.myapplication.ui.theme.colorWhite
import com.example.myapplication.ui.viewmodel.CardPaymentViewModel
import com.example.myapplication.ui.viewmodel.QuoteDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class CardPaymentScreenActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val cardPaymentViewModel: CardPaymentViewModel = hiltViewModel()


               // cardPaymentViewModel.processCardPayment() //todo remove
               // PayWithCardScreen(rememberNavController())
            }
        }
    }
}


@Composable
fun PayWithCardActivityScreen (
    cardPaymentViewModel: CardPaymentViewModel,
    quoteDetailsViewModel: QuoteDetailsViewModel,
    navHostController: NavHostController

) {
    PayWithCardScreen(
        cardPaymentViewModel = cardPaymentViewModel,
        quoteDetailsViewModel=quoteDetailsViewModel,
        onEvent= {
                cardPaymentEvent->
                 cardPaymentViewModel.onEvent(cardPaymentEvent)
        },

        navHostController =navHostController
    )
    
}



@Composable
fun PayWithCardScreen(
    cardPaymentViewModel: CardPaymentViewModel,
    quoteDetailsViewModel: QuoteDetailsViewModel,
    onEvent: (CardPaymentEvent)->Unit,
    navHostController: NavHostController) {

    PayWithCardScreenContent(
        onUpdateIsError = {isError->

            cardPaymentViewModel.onEvent(CardPaymentEvent.OnUpdateIsError(isError))


        },

        onUpdateShowErrorDialog={showErrorDialog->

            cardPaymentViewModel.onEvent(CardPaymentEvent.OnUpdateShowErrorDialog(showErrorDialog))



        },



        onUpdatePayNowButtonWasClickedByUser= {wasPayNowButtonClickedByUser ->

                                             cardPaymentViewModel.onEvent(CardPaymentEvent.OnUpdatePayNowButtonWasClickedByUser(wasPayNowButtonClickedByUser))

        },

        onUpdateShowExpiryYearDialog = { isShowExpiryYear->

            cardPaymentViewModel.onEvent(CardPaymentEvent.OnUpdateShowExpiryYearDialog(isShowExpiryYear))


        },

        onUpdateNameOnCard = { nameOnCard ->
                             onEvent(CardPaymentEvent.OnUpdateNameOnCard(nameOnCard))

        },

        onUpdateCardNumber = { cardNumber ->
                            onEvent(CardPaymentEvent.OnUpdateCardNumber(cardNumber))



        },


        onUpdateCardExpiryMonth = { cardExpiryMonth ->
                                  onEvent(CardPaymentEvent.OnUpdateCardExpiryMonth(cardExpiryMonth))

        },
        onUpdateCardExpiryYear = { cardExpiryYear->
                              onEvent(CardPaymentEvent.OnUpdateCardExpiryYear(cardExpiryYear))


        },

        onUpdateCardCvv = {cardCvv ->
                          onEvent(CardPaymentEvent.OnUpdateCardCvvNumber(cardCvv))


        },

        onUpdateCurrentCardAmountUserToPay = {amount->
                                 onEvent(CardPaymentEvent.OnUpdateCurrentCardAmountUserToPay(amount))
        },


        onUpdateCurrentCardQuoteNumber={ quoteNumber->
                                     onEvent(CardPaymentEvent.OnUpdateCurrentCardQuoteNumber(quoteNumber))

        },

        onUpdateCurrentCardQuoteCode = { quoteCode->

                             onEvent(CardPaymentEvent.OnUpdateCurrentCardQuoteCode(quoteCode))

        },

        onUpdateDoCardDetailsValidation={doValidation->

            onEvent(CardPaymentEvent.OnUpdateDoCardDetailsValidation(doValidation))

        },

        onUpdateShowMonthsDialog = { showMonthsDialog->

                     onEvent(CardPaymentEvent.OnUpdateShowMonthsDialog(showMonthsDialog))
        },


        onUpdateMonthSelected = { monthSelected->

            onEvent(CardPaymentEvent.OnUpdateMonthSelected(monthSelected))


        },

        onUpdateYearSelected={yearSelected->

            onEvent(CardPaymentEvent.OnUpdateYearSelected(yearSelected))


        },

        onUpdateIsExpiryMonthInvalid={ isMonthInvalid->

            onEvent(CardPaymentEvent.OnUpdateIsExpiryMonthInvalid(isMonthInvalid))


        },

        onUpdateYearsToChooseFrom = {  onUpdateYearsToChooseFrom->

            onEvent(CardPaymentEvent.OnUpdateYearsToChooseFromStartingWithCurrentYears(onUpdateYearsToChooseFrom))


        },




        quoteDetailsViewState = quoteDetailsViewModel.quoteDetailsState,


        cardPaymentViewState = cardPaymentViewModel.cardPaymentState,




        navHostController=navHostController
    )



}






    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PayWithCardScreenContent(onUpdateIsError:(Boolean)->Unit, onUpdateShowErrorDialog:(Boolean)->Unit, onUpdateYearsToChooseFrom:(Boolean)->Unit, onUpdateShowExpiryYearDialog:(Boolean)->Unit, onUpdateIsExpiryMonthInvalid:(Boolean)->Unit, onUpdateMonthSelected:(String)->Unit, onUpdateYearSelected:(String)->Unit, onUpdateShowMonthsDialog:(Boolean)->Unit, onUpdateDoCardDetailsValidation:(Boolean)->Unit, onUpdateCurrentCardQuoteCode:(String)->Unit, onUpdateCurrentCardQuoteNumber:(String)->Unit, onUpdateCurrentCardAmountUserToPay:(String)->Unit, onUpdatePayNowButtonWasClickedByUser:(Boolean)->Unit, onUpdateNameOnCard:(String)->Unit, onUpdateCardNumber:(String)->Unit, onUpdateCardExpiryMonth:(String)->Unit, onUpdateCardExpiryYear:(String)->Unit, onUpdateCardCvv:(String)->Unit, quoteDetailsViewState: QuoteDetailsViewState, cardPaymentViewState: CardPaymentViewState,
                                 navHostController: NavHostController ) {


        LaunchedEffect(Unit){
            //update the current years user can choose from

            onUpdateYearsToChooseFrom(true)


        }





        var textForFieldNameOnCard by remember { mutableStateOf("") }
        var textForFieldCardNumber by remember { mutableStateOf("") }
        var textForFieldExpiryMonth by remember { mutableStateOf("") }
        var textForFieldExpiryYear by remember { mutableStateOf("") }
        var textForFieldCVVNumber by remember { mutableStateOf("") }


        //val density = LocalDensityOwner.currentDensity
        val density = LocalDensity.current
        val elevation = with(density) { 0.5.dp } // Adjust the elevation as needed


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorWhite)
                .fillMaxSize()

        ) {

            Box(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            ) {

                TopAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),

                    navigationIcon = {
                        IconButton(
                            onClick = { /* TODO Handle navigation icon click */
                                navHostController.navigateUp()
                            }
                        ) {
                            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Back icon")
                        }
                    },

                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = colorWhite
                    ),
                    title = {
                        Text(
                            text = "Pay with a Debit/Credit Card",
                            modifier = Modifier.padding( 2.dp),
                            color = colorPrimary,
                            fontWeight = FontWeight.Bold

                        )
                    },
                    actions = {}
                )
            }


                Spacer(modifier = Modifier.height(1.dp))


                Column(
                    modifier = Modifier
                        .padding(top = 4.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                    //  .verticalScroll(enabled = true, state = ScrollState(0)),,
                    ,
                    verticalArrangement = Arrangement.spacedBy(0.5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = R.drawable.creditcard),
                        contentDescription = "credit card icon",
                        modifier = Modifier
                            .background(androidx.compose.ui.graphics.Color.Transparent)
                            .size(50.dp)
                    )


                    Spacer(modifier = Modifier.height(20.dp))
                    //OutlinedTextField( value = "", onValueChange ={},  modifier = Modifier.padding(bottom = 8.dp), maxLines = 1)
//
//                OutlinedTextField(
//                    value = {},
//                    onValueChange = { /* Handle surname input */ },
//                    placeholder = { Text(text = "Surname")},
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )

                    val paymentAmount=quoteDetailsViewState.currentSelectedPaymentAmountInRadioButton+".00"



                    Text(
                        text = "Paying Ksh  $paymentAmount",
                        color = colorPrimary,
                        fontWeight = FontWeight.Bold,
                        //  modifier=Modifier.align(AbsoluteAlignment.Left),
                        style = MaterialTheme.typography.titleMedium

                    )

                    val amount=quoteDetailsViewState.currentSelectedPaymentAmountInRadioButton
          //          val amount="2"

                    val quoteNumber=quoteDetailsViewState.quoteNumberOfCurrentQuote

                    val quoteCode=quoteDetailsViewState.quoteCodeOfCurrentQuote


                    Log.d("amount is ","amount is "+amount )

                    LaunchedEffect(Unit){
                        onUpdateCurrentCardAmountUserToPay(amount)
                        onUpdateCurrentCardQuoteNumber(quoteNumber)
                        onUpdateCurrentCardQuoteCode(quoteCode)
                    }






                    Text(
                        text = "Name on Card",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .align(AbsoluteAlignment.Left)
                    )
                    TextField(
                        value = cardPaymentViewState.nameOnCard,
                        onValueChange = { nameOnCard->
                          //  textForFieldNameOnCard = it

                                        // trim leading and triling spaces before updating. Also convert input to capital
                                        onUpdateNameOnCard(nameOnCard.trim().uppercase(Locale.getDefault()))


                                        },
                        maxLines = 1,
                        placeholder = { Text(text = "e.g JAMES BOND") },

                        supportingText = {

                            if (cardPaymentViewState.isNameOnCardEmpty && cardPaymentViewState.isNameOnCardInvalid) {
                                Text(
                                    text = "Enter card name",
                                    color = colorPrimary,
                                    modifier = Modifier.padding(2.dp)
                                )

                            }

                            if (cardPaymentViewState.isNameOnCardInvalid && !cardPaymentViewState.isNameOnCardEmpty){
                                Text(
                                    text = stringResource(id = R.string.error_invalid_card_name),
                                    color = colorPrimary,
                                    modifier = Modifier.padding(2.dp)
                                )
                            }


                                         },


                        colors = TextFieldDefaults.textFieldColors(
                            textColor = colorBlack,
                            containerColor = androidx.compose.ui.graphics.Color.Transparent,
                            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Companion.Transparent, // Transparent color for focused line
                            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent // Transparent color for unfocused line
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                1.dp,
                                colorPrimary,
                                shape = MaterialTheme.shapes.small
                            ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Card Number",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .align(AbsoluteAlignment.Left)
                    )
                    TextField(
                        value = cardPaymentViewState.cardNumber,
                        onValueChange = {cardnumber->
                            if (cardnumber.length<=16) {
                             //   textForFieldCardNumber = cardnumber


                                onUpdateCardNumber(cardnumber)


                            }
                                        },
                        maxLines = 1,
                        placeholder = { Text(text = "e.g 4XXXXXXXXXXXXXXX") },

                        supportingText = {

                            if (cardPaymentViewState.isCardNumberEmpty) {
                                Text(
                                    text = "Enter card number",
                                    color = colorPrimary,
                                    modifier = Modifier.padding(2.dp)
                                )

                            }

                            if (cardPaymentViewState.isCardNumberInvalid && !cardPaymentViewState.isNameOnCardEmpty){
                                Text(
                                    text = "",
                                    color = colorPrimary,
                                    modifier = Modifier.padding(2.dp)
                                )
                            }


                        },




                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = androidx.compose.ui.graphics.Color.Transparent,
                            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Companion.Transparent, // Transparent color for focused line
                            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent // Transparent color for unfocused line
                            , cursorColor = colorPrimary,
                            textColor = colorBlack
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                1.dp,
                                colorPrimary,
                                shape = MaterialTheme.shapes.small
                            ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    Text(
                        text = "Expire date",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .align(AbsoluteAlignment.Left),
                        fontWeight = FontWeight.Bold
                    )

                    Row(modifier = Modifier.fillMaxWidth()) {


                        TextField(
                            value = cardPaymentViewState.cardExpiryMonth,
                            onValueChange = { cardExpiryMonth->

                                if (cardExpiryMonth.length<=2) {
                                   // textForFieldExpiryMonth = cardExpiryMonth
                                    onUpdateCardExpiryMonth(cardExpiryMonth)

                                }

                                            },
                            maxLines = 1,
                            trailingIcon = {
                                IconButton(
                                    onClick = { /* TODO handle arrow downicon click */

                                    onUpdateShowMonthsDialog(true)

                                              },
                                    content = {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowDown,
                                            contentDescription = "year picker"
                                        )
                                    }
                                )

                            },

                            label = { Text(text = "Month") },
                            placeholder = { Text(text = "e.g 03") },

                            supportingText = {

                                if (cardPaymentViewState.isCardExpiryMonthEmpty) {
                                    Text(
                                        text = "Enter value",
                                        color = colorPrimary,
                                        modifier = Modifier.padding(2.dp)
                                    )

                                }

                                if (cardPaymentViewState.isCardExpiryMonthInvalid && !cardPaymentViewState.isCardExpiryMonthEmpty){
                                    Text(
                                        text = "",
                                        color = colorPrimary,
                                        modifier = Modifier.padding(2.dp)
                                    )
                                }


                            },





                            colors = TextFieldDefaults.textFieldColors(
                                textColor = colorBlack,
                                containerColor = androidx.compose.ui.graphics.Color.Transparent,
                                focusedIndicatorColor = androidx.compose.ui.graphics.Color.Companion.Transparent, // Transparent color for focused line
                                unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent // Transparent color for unfocused line
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .border(
                                    1.dp,
                                    colorPrimary,
                                    shape = MaterialTheme.shapes.small
                                ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )






                        if ( cardPaymentViewState.showMonthsDialog) {
                            CustomScrollableDialogForMonthAndYearPicking(
                                items = cardPaymentViewState.months,
                                onDismissRequest = { /*TODO*/
                                    //update make showVehicleMakesDialog to =false

                                    onUpdateShowMonthsDialog(false)

                                },
                                onItemSelected = {

                                        itemSelected ->
                                    onUpdateMonthSelected(itemSelected)


                                    onUpdateIsExpiryMonthInvalid(false)
                                },

                                onDismissRequestForYearPicker = {  dismissYearPicker ->

                                    onUpdateShowExpiryYearDialog(dismissYearPicker)

                                },

                                isMonthPicker = true,

                                onItemSelectedYear = {   selectedYear ->
                                    onUpdateYearSelected(selectedYear)

                                }

                            )

                        }















                        Spacer(modifier = Modifier.width(4.dp))


                        TextField(
                            value = cardPaymentViewState.cardExpiryYear,
                            onValueChange = { cardExpiryYear->
                                if (cardExpiryYear.length<=4) {
                                  //  textForFieldExpiryYear = cardExpiryYear

                                    onUpdateCardExpiryYear(cardExpiryYear)

                                }
                                            },
                            maxLines = 1,
                            trailingIcon = {
                                IconButton(
                                    onClick = { /* TODO handle arrow downicon click */

                                              onUpdateShowExpiryYearDialog(true)


                                              },
                                    content = {
                                        Icon(
                                            imageVector = Icons.Default.KeyboardArrowDown,
                                            contentDescription = "year picker"
                                        )
                                    }
                                )

                            },
                            label = { Text(text = "Year") },
                            placeholder = { Text(text = "e.g 2029") },

                            supportingText = {

                                if (cardPaymentViewState.isCardExpiryYearEmpty) {
                                    Text(
                                        text = "Enter value",
                                        color = colorPrimary,
                                        modifier = Modifier.padding(2.dp)
                                    )

                                }

                                if (cardPaymentViewState.isCardExpiryYearInvalid && !cardPaymentViewState.isCardExpiryYearEmpty){
                                    Text(
                                        text = "",
                                        color = colorPrimary,
                                        modifier = Modifier.padding(2.dp)
                                    )
                                }


                            },



                            colors = TextFieldDefaults.textFieldColors(
                                textColor = colorBlack,
                                containerColor = androidx.compose.ui.graphics.Color.Transparent,
                                focusedIndicatorColor = androidx.compose.ui.graphics.Color.Companion.Transparent, // Transparent color for focused line
                                unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent // Transparent color for unfocused line
                            ),
                            modifier = Modifier
                                .weight(1f)
                                .border(
                                    1.dp,
                                    colorPrimary,
                                    shape = MaterialTheme.shapes.small
                                ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            )
                        )


                    }



                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "CVV number",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .align(AbsoluteAlignment.Left),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Last 3 digits on the back of your card",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .align(AbsoluteAlignment.Left)
                    )


                    TextField(
                        value = cardPaymentViewState.cardCvvNumber,
                        onValueChange = {cvv->
                            if(cvv.length<=3) {
                               // textForFieldCVVNumber = cvv

                                onUpdateCardCvv(cvv)


                            }

                                        },
                        maxLines = 1,
                        label = { Text(text = "CVV") },
                        placeholder = { Text(text = "e.g XXX") },

                        supportingText = {

                            if (cardPaymentViewState.isCardCvvNumberEmpty) {
                                Text(
                                    text = "Enter value",
                                    color = colorPrimary,
                                    modifier = Modifier.padding(2.dp)
                                )

                            }

//                            if (cardPaymentViewState.isCardCvvNumberInvalid && !cardPaymentViewState.isCardCvvNumberEmpty){
//                                Text(
//                                    text = "",
//                                    color = colorPrimary,
//                                    modifier = Modifier.padding(2.dp)
//                                )
//                            }


                        },





                        colors = TextFieldDefaults.textFieldColors(
                            textColor = colorBlack,
                            containerColor = androidx.compose.ui.graphics.Color.Transparent,
                            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Companion.Transparent, // Transparent color for focused line
                            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent // Transparent color for unfocused line
                        ),
                        modifier = Modifier
                            .width(100.dp)
                            .border(
                                1.dp,
                                colorPrimary,
                                shape = MaterialTheme.shapes.small
                            )
                            .align(AbsoluteAlignment.Left),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),

                        )



                    Spacer(modifier = Modifier.height(16.dp))

                   // Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = { /*TODO*/

                            onUpdateDoCardDetailsValidation(true)

                            if (cardPaymentViewState.isNameOnCardValid && cardPaymentViewState.isCardNumberValid && cardPaymentViewState.isCardExpiryMonthValid && cardPaymentViewState.isCardExpiryYearValid && cardPaymentViewState.isCardCvvNumberValid) {

                                onUpdatePayNowButtonWasClickedByUser(true)

                            }



                      //      navHostController.navigate("PaymentSuccessScreen")


                        },
                        colors = ButtonDefaults.buttonColors(colorPrimary),
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Pay now")
                    }





                    /** conditional UI **/
                    if (cardPaymentViewState.isProcessCardPaymentApiLoading || cardPaymentViewState.isConvertToPolicyApiLoading) {

                        CircularProgressIndicator()

                    }



                    if ( cardPaymentViewState.isProcessCardPaymentApiSuccess  && cardPaymentViewState.isConvertToPolicyApiSuccess) {
                       // navHostController.navigate("PaymentSuccessScreen")
                        //todo assign 0 to batch no
                        navHostController.navigate("PaymentSuccessScreen/0/card")
                    }


                    if (cardPaymentViewState.showYearsDialog){


                        CustomScrollableDialogForMonthAndYearPicking(
                            items = cardPaymentViewState.years,
                            onDismissRequest = { /*TODO*/
                                //update make showVehicleMakesDialog to =false

                                onUpdateShowMonthsDialog(false)

                            },
                            onItemSelected = {

                                    itemSelected ->
                                onUpdateMonthSelected(itemSelected)


                                onUpdateIsExpiryMonthInvalid(false)
                            },

                            onDismissRequestForYearPicker = {  dismissYearPicker ->

                                onUpdateShowExpiryYearDialog(dismissYearPicker)
                                onUpdateShowMonthsDialog(false)

                            },


                            isMonthPicker = false,

                            onItemSelectedYear = {   selectedYear ->
                                onUpdateYearSelected(selectedYear)


                                //onUpdateIsExpiryYearInvalid(false)

                            }



                        )



                    }






                    if(cardPaymentViewState.isProcessCardPaymentApiError || cardPaymentViewState.isConvertToPolicyApiError){

                        RequestFailedDialog(errorInfo = cardPaymentViewState.apiError?.message,
                            onDismiss = {showErrorDialog->

                                onUpdateShowErrorDialog(showErrorDialog)
                                onUpdateIsError(showErrorDialog)


                            })

                    }



                    /** end of conditional UI **/





                }
            }











        }




    @Preview
    @Composable
    fun CardPaymentSreenPreview(){
        val navController= rememberNavController()
        val cardPaymentViewState= CardPaymentViewState()
        val quoteDetailsViewState:QuoteDetailsViewState=QuoteDetailsViewState()

        PayWithCardScreenContent({},{},{},{},{},{},{},{},{},{},{}, {},{},{},{},{},{}, {}, quoteDetailsViewState, cardPaymentViewState, navController)

    }


