package com.example.androidcleanarchitectureproject.ui.compose.card_payment

sealed class CardPaymentEvent {
    //card details updates

    data class OnUpdateShowErrorDialog (var showErrorDialog:Boolean): CardPaymentEvent()




    data class OnUpdateShowMonthsDialog (var showMonthsDialog:Boolean): CardPaymentEvent()
    data class OnUpdateMonthSelected (var monthSelected:String): CardPaymentEvent()


    data class OnUpdateYearSelected (var yearSelected:String): CardPaymentEvent()





    data class OnUpdateIsExpiryMonthInvalid (var isExpiryMonthInvalid:Boolean): CardPaymentEvent()


    data class OnUpdateYearsToChooseFromStartingWithCurrentYears (var updateYears:Boolean) :
        CardPaymentEvent()




    data class OnUpdateDoCardDetailsValidation (var doValidation:Boolean): CardPaymentEvent()

    data class OnUpdateCurrentCardAmountUserToPay (var amount:String): CardPaymentEvent()
    data class OnUpdateCurrentCardQuoteNumber (var quoteNumberRef:String): CardPaymentEvent()

    data class OnUpdateCurrentCardQuoteCode (var quoteCode:String): CardPaymentEvent()


    data class OnUpdateShowExpiryYearDialog (var isShowExpiryYearDialog:Boolean) : CardPaymentEvent()



    data class OnUpdateNameOnCard (var nameOnCard:String): CardPaymentEvent()
    data class OnUpdateCardNumber (var cardNumber:String): CardPaymentEvent()
    data class OnUpdateCardExpiryMonth (var cardExpiryMonth:String): CardPaymentEvent()
    data class OnUpdateCardExpiryYear (var cardExpiryYear:String): CardPaymentEvent()
    data class OnUpdateCardCvvNumber (var cardCvvNumber:String): CardPaymentEvent()






    data class OnUpdateIsPayNowButtonClicked(var isPayNowButtonClicked:Boolean): CardPaymentEvent()




    data class OnUpdatePayNowButtonWasClickedByUser(var wasPayNowButtonClickedByUser:Boolean) :
        CardPaymentEvent()





    //validation updates
    //valid updates
    data class OnUpdateIsNameOnCardValid (var isNameOnCardValid:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardNumberValid (var isCardNumberValid:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardExpiryMonthValid (var isCardExpiryMonthValid:Boolean):
        CardPaymentEvent()
    data class OnUpdateIsCardExpiryYearValid (var isCardExpiryYearValid:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardCvvNumberValid (var isCardCvvNumberValid:Boolean): CardPaymentEvent()







    //invalid updates
    data class OnUpdateIsNameOnCardInvalid (var isNameOnCardInvalid:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardNumberInvalid (var isCardNumberInvalid:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardExpiryMonthInvalid (var isCardExpiryMonthInvalid:Boolean):
        CardPaymentEvent()
    data class OnUpdateIsCardExpiryYearInvalid (var isCardExpiryYearInvalid:Boolean):
        CardPaymentEvent()
    data class OnUpdateIsCardCvvNumberInvalid (var isCardCvvNumberInvalid:Boolean):
        CardPaymentEvent()




    //updates for empty state
    data class OnUpdateIsNameOnCardEmpty (var isNameOnCardEmpty:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardNumberEmpty (var isCardNumberEmpty:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardExpiryMonthEmpty (var isCardExpiryMonthEmpty:Boolean):
        CardPaymentEvent()
    data class OnUpdateIsCardExpiryYearEmpty (var isCardExpiryYearEmpty:Boolean): CardPaymentEvent()
    data class OnUpdateIsCardCvvNumberEmpty (var isCardCvvNumberEmpty:Boolean): CardPaymentEvent()









    data class OnUpdateIsError (var isError:Boolean): CardPaymentEvent()



    //other event objects
    object DoInitialTasksUponLaunch: CardPaymentEvent()
    object OnClickPayNow: CardPaymentEvent()
    object OnClickOtherEvent: CardPaymentEvent()


}