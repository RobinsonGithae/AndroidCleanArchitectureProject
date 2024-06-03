package com.example.androidcleanarchitectureproject.utils

import java.math.BigDecimal


/**
 * A simple custom string to BigDecimal Converter with exception handing Util
 * Author: Robinson Githae
 *
 */

object CustomStringToBigDecimal {

    fun toBigDecimal(string: String): BigDecimal {
        var bigDecimalValue = BigDecimal(0)

        try {
            bigDecimalValue = string.toBigDecimal()
        } catch (e: Exception) { e.message }


        return bigDecimalValue
    }


}