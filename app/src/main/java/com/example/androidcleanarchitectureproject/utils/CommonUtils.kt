package com.example.androidcleanarchitectureproject.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import android.util.Patterns
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.regex.Pattern


object CommonUtils {


     const val numberPlateRegex = "^K[A-Z]{2} [0-9]{3}[A-Z]|" +
            "G[A-Z]{2} [0-9]{3}[A-Z]$|" +
            "^[A-Z]{3} [0-9][A-Z][0-9]{3}$|" +
            "^[0-9]{2}[A-Z]{2} [0-9]{2}[A-Z]$|" +
            "^[A-Z]{2} [0-9]{3} [A-Z]{2}$"
     const val kraPinRegex = "^A[0-9]{9}[A-Z]$"
     const val cardNameRegex = "^[A-Z]+ [A-Z]{2,}$"
    private const val motorcycleNumberPlateRegex="^K[A-Z]{3} [0-9]{3}[A-Z]{1}$"
    private const val passwordRegex = "^" +
            "(?=.*[0-9])" +  //at least 1 digit
            "(?=.*[a-z])" +  //at least 1 lower case letter
            "(?=.*[A-Z])" +  //at least 1 upper case letter
            "(?=.*\\d)" +  //at least 1 digit
            "(?=.*[@#$%^&+=!'<>?/|{}_.~`*()])" +  //special characters inclusion
            "(?=.*[a-zA-Z])" +  //any letter
            "(?=\\S+$)" +  //no white spaces
            ".{8,}" +  //at least 8 characters
            "$"




        const val nationalIdRegex="^\\d{7,8}\$"   // The \d{7,8} Matches id number to 7 to 8 digits while $ indicates End of the string and ^ indicates the Start of the string




    const val specialCharactersRegexExpression="[^A-Za-z0-9 ]"

    const val capitalLetterRegexExpression = "[A-Z]"

    const val smallLetterRegexExpression = "[a-z]"

      const val cvvRegex="^\\d{3}\$"


    val currentTimestamp: Long = Date().time












    fun stringIsEqual(val1: String, val2: String): Boolean = TextUtils.equals(val1, val2)

    /**
     * generate cover end date
     *
     */
    fun defaultEndDate(calendarStart: Calendar): Long {
        return Calendar.getInstance().apply {
            set(Calendar.YEAR, calendarStart.get(Calendar.YEAR) + 1)
            set(Calendar.MONTH, calendarStart.get(Calendar.MONTH))
            set(Calendar.DAY_OF_MONTH, calendarStart.get(Calendar.DAY_OF_MONTH) - 1)
        }.timeInMillis
    }


    /**
     * Open dialer with the phone number to call
     *
     * @param context
     * @param number
     */
    fun call(context: Context, number: String?) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$number")
        context.startActivity(intent)
    }


    /**
     * Send email
     *
     * @param context
     * @param email
     */
    fun composeEmail(context: Context, email: Array<String>) {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:") // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        context.startActivity(intent)
    }



    /**
     * Open whatsapp contact
     *
     * @param context
     * @param number
     */
    fun openWhatsappContact(context: Context, number: String) {
        val uri = Uri.parse("smsto:$number")
        val i = Intent(Intent.ACTION_SENDTO, uri)
        i.setPackage("com.whatsapp")
        context.startActivity(Intent.createChooser(i, ""))
    }


    fun share(context: Context, message: String, title: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        context.startActivity(Intent.createChooser(sendIntent, title))
    }


    fun StringIsEmpty(string: String?): Boolean {
        if (string != null) {
            return string.isEmpty()
        } else {return false}
    }










    fun isEmailValid(email: String?): Boolean {
        return !Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun stringIsEmpty(string: String): Boolean {
        return string.isEmpty()
    }

    fun mobileLength(number: String): Boolean {
        return number.length >= 10 && number.length<11
    }

    fun emailLength(email: String?):Boolean {
        return email?.length!! < 100
    }

    fun isValidLimit(amount: BigDecimal, limit: BigDecimal?): Boolean {
        return amount.compareTo(limit) < 0
    }

    fun verifyCardName(cardName: String?): Boolean {
        val p = Pattern.compile(cardNameRegex)
        val m = p.matcher(cardName)
        return !m.matches()
    }

    fun verifyKRAPin(kraNumber: String?): Boolean {
        val p = Pattern.compile(kraPinRegex)
        val m = p.matcher(kraNumber)
        return !m.matches()
    }

    fun StringIsEqual(val1: String?, val2: String?): Boolean {
        return val1.equals(val2)
    }

    fun ObjectIsNotNull(`object`: Any?): Boolean {
        return `object` != null
    }

    fun formatSingleDate(singledate: String?): String {
        var singledate = singledate
        if (singledate != null) {
            if (singledate.length == 1) {
                singledate = "0$singledate"
            }
        }
        return singledate ?: ""
    }




//    @SuppressLint("DefaultLocale")
//    fun StringToCurrency(amount: String?): String {
//        if (amount != null) {
//            return if (!amount.equals("0", ignoreCase = true) && amount.isNotEmpty()) {
//                try {
//                    String.format("%,.2f", java.lang.Double.valueOf(amount))
//                } catch (e:NumberFormatException){
//
//                }
//
//            } else amount
//        }
//    }


   // @SuppressLint("DefaultLocale")
//    fun StringToCurrency(amount: String?): String {
//
//        val defaultAmount=amount
//
//        if (!amount.isNullOrEmpty()) {
//            try {
//                var formattedString="0"
//                val doubleAmount=amount.toDouble()
//                 formattedString= String.format("%,.2f", java.lang.Double.valueOf(doubleAmount))
//
//                return formattedString
//
//            } catch (e:NumberFormatException){
//                e.message
//
//               val formattedString= amount
//                return formattedString
//
//            }
//
//
//        }
//
//        else return defaultAmount?:""
//    }



    fun StringToCurrency(number: String): String {
        if (number.isNotEmpty()) {
            val formatter =
                NumberFormat.getNumberInstance(Locale.US) // US locale for comma separation
            formatter.maximumFractionDigits = 2 // Set decimal places to 2 (can be adjusted)
            return formatter.format(number.toDouble())

        } else{return ""}
    }









    fun isValidRegistrationNumber(propertyId: String?): Boolean {
        val p = Pattern.compile(numberPlateRegex)
        val m = p.matcher(propertyId)
        return !m.matches()
    }

    fun phaseNumber(number: String): String {
        var phasedNumber = StringBuilder()
        if (number.length >= 5) {
            for (i in 0..number.length - 3) {
                phasedNumber.append("*")
            }
            phasedNumber.append(number.substring(number.length - 3))
        } else {
            phasedNumber = StringBuilder(number)
        }
        return phasedNumber.toString()
    }

    fun PasswordStrength(password: String?): Boolean {
        val p = Pattern.compile(passwordRegex)
        val m = p.matcher(password)
        return !m.matches()
    }

    fun phaseOtp(data: String?): String {
        val pattern = Pattern.compile("(\\d{4})")
        val matcher = pattern.matcher(data)
        var code = ""
        if (matcher.find()) {
            code = matcher.group(0)
        }
        return code
    }

    fun isPinPasswordValid(pin:String?): Boolean{
        return pin?.length!! >=7 && /* pin.isDigitsOnly() && */ pin.isNotEmpty()
    }

    fun isLoginPinPasswordValid(pin:String): Boolean{
        if(pin.isEmpty()){return false} else{return true}

    }

    fun isPhoneNumberValid(userinput:String):Boolean{

        return mobileLength(userinput) && ObjectIsNotNull(userinput)

    }


    fun errorMessage(errorMessage:String):String{
        return errorMessage
    }

    fun hasNoNonTextSymbols(name: String):Boolean {

        if (
            name.none{it in setOf( '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
                ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@',
                '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~') }
            ){}
        return false
    }

    fun isNameValid(name:String?):Boolean{
        if (name!=null ) {
            if (name.length >= 2){
                return true
            }
        }
        else { return false }
        return false
    }






    fun validateLoginDetailsOkay(username:String,password: String):Boolean{
        if (isPinPasswordValid(password) && isPhoneNumberValid(password)){
            return true

        } else
            return false
    }


}

