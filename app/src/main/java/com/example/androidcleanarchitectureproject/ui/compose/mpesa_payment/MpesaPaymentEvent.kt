package com.example.myapplication.ui.compose.mpesa_payment

sealed class MpesaPaymentEvent {




    data class  OnUpdateConvertQuoteToPolicy (var convertQuoteToPolicy:Boolean):MpesaPaymentEvent()



    data class OnUpdateShowErrorDialog (var showErrorDialog:Boolean):MpesaPaymentEvent()

    //mpesa update events
    data class OnUpdateProcessMpesaStkPush (var isProcessMpesaStkPush:Boolean):MpesaPaymentEvent()
    data class OnUpdateUserClickedDoneMpesaButton(var isUserClickedDoneMpesaButton:Boolean) :MpesaPaymentEvent()


    data class OnUpdateSetMpesaEnabledOptionsApiSuccessToFalseToCloseStkDialog(var isSetAsFalse:Boolean) :MpesaPaymentEvent()




    data class OnUpdateIsError (var isError:Boolean):MpesaPaymentEvent()




    data class OnUpdateAmountToBePaid(var amountToBePaid:String) :MpesaPaymentEvent()

    data class OnUpdateQuoteNumberOfCurrentQuote(var quoteNumberOfCurrentQuote:String) :MpesaPaymentEvent()

    data class OnUpdateAgentCodeOfCurrentSelectedAgent(var agentCodeOfCurrentAgent:String) :MpesaPaymentEvent()







    //other event objects
    object DoInitialTasksUponLaunch: MpesaPaymentEvent()
    object OnClickOtherEvent:MpesaPaymentEvent()


}