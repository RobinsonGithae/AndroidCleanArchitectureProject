package com.example.androidcleanarchitectureproject.utils


import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.DecimalFormat
import kotlin.math.max
import kotlin.math.min

class CurrencyVisualTransform(
    var maxFractionDigits: Int = 2,
    var minFractionDigits: Int = 0
) : VisualTransformation {

    private val symbols = DecimalFormat().decimalFormatSymbols

    private val commaReplacementPattern = Regex("\\B(?=(?:\\d{3})+(?!\\d))")

    override fun filter(text: AnnotatedString): TransformedText {
        if (text.isEmpty())
            return TransformedText(text, OffsetMapping.Identity)

        val comma = symbols.groupingSeparator
        val dot = symbols.decimalSeparator
        val zero = symbols.zeroDigit

        var (intPart, fracPart) = text.text.split(dot)
            .let { Pair(it[0], it.getOrNull(1)) }

        //Ensure there is at least one zero for integer places
        val normalizedIntPart =
            if (intPart.isEmpty() && fracPart != null) zero.toString() else intPart

        val integersWithComma =
            normalizedIntPart.replace(commaReplacementPattern, comma.toString())

        val minFractionDigits = min(this.maxFractionDigits, this.minFractionDigits)
        if (minFractionDigits > 0 || !fracPart.isNullOrEmpty()) {
            if (fracPart == null)
                fracPart = ""

            fracPart = fracPart.take(maxFractionDigits).padEnd(minFractionDigits, zero)
        }

        val out = AnnotatedString(
            integersWithComma + if (fracPart == null) "" else ".$fracPart",
            text.spanStyles,
            text.paragraphStyles
        )
        val offsetMapping = ThousandSeparatorOffsetMapping(
            intPart.length,
            integersWithComma.length,
            out.length,
            integersWithComma.indices.filter { integersWithComma[it] == comma }.asSequence(),
            normalizedIntPart != intPart
        )

        return TransformedText(out, offsetMapping)
    }

    private inner class ThousandSeparatorOffsetMapping(
        val originalIntegerLength: Int,
        val transformedIntegersLength: Int,
        val transformedLength: Int,
        val commaIndices: Sequence<Int>,
        addedLeadingZero: Boolean
    ) : OffsetMapping {
        val commaCount = calcCommaCount(originalIntegerLength)

        val leadingZeroOffset = if (addedLeadingZero) 1 else 0

        override fun originalToTransformed(offset: Int): Int =
            // Adding number of commas behind the character
            when {
                offset >= originalIntegerLength -> if (offset - originalIntegerLength > maxFractionDigits) transformedLength
                else
                    offset + commaCount + leadingZeroOffset
                else -> offset + (commaCount - calcCommaCount(originalIntegerLength - offset))
            }

        override fun transformedToOriginal(offset: Int): Int =
            // Subtracting number of commas behind the character
            when {
                offset >= transformedIntegersLength -> min(offset - commaCount, transformedLength) - leadingZeroOffset
                else -> offset - commaIndices.takeWhile { it <= offset }.count()
            }

        private fun calcCommaCount(intDigitCount: Int) =
            max((intDigitCount - 1) / 3, 0)
    }
}
