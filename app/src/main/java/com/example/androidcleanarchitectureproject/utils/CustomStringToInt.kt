package com.example.androidcleanarchitectureproject.utils


/**
 * A simple custom string to Int Converter with exception handing Util
 * Author: Robinson Githae
 *
 */

object CustomStringToInt {

    fun toInt(string: String): Int {
        var intValue = 0

        try {
            intValue = string.toInt()
        } catch (e: Exception) { e.message }


        return intValue
    }


}