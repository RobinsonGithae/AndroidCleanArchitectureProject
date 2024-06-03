package com.example.androidcleanarchitectureproject.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.ui.graphics.vector.ImageVector
import java.math.BigDecimal


/**
 * A simple custom string to Int Converter with exception handing Util
 * Author: Robinson Githae
 *
 */

object CustomIconSetterUtil {

    fun setImageVectorBasedOnReceivedGroupType(groupType: Int): ImageVector {

        if (groupType.equals(null)){
            return Icons.Default.Person
        }

        if (groupType.equals(1)){
            //set phone icon if group type is 1
            return Icons.Default.Call

        }

        if (groupType.equals(2)){
            //set email icon if group type is 2
            return Icons.Default.Email
        }

        //BY default return this if no condition is met
        return Icons.Default.Person
    }


}