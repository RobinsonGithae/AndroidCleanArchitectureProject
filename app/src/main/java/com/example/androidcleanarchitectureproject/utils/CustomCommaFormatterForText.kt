package com.example.androidcleanarchitectureproject.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

/**
 * A simple custom FormatterForText
 * Author: Robinson Githae
 * 23rd May, 2024
 *
 */

object CustomCommaFormatterForText {

    fun formatWithCommas(input: String?): String {

        if (input?.isNotEmpty() == true) {
            val symbols = DecimalFormatSymbols().apply {
                groupingSeparator = ','
            }
            val decimalFormat = DecimalFormat("#,###.##", symbols)
            return decimalFormat.format(input.toDouble())

        } else {
            return ""
        }

    }


}