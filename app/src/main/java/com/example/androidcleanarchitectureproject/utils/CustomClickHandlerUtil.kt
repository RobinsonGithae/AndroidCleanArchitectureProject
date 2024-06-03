package com.example.androidcleanarchitectureproject.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Patterns

object CustomClickHandlerUtil {


    fun handleContactClick(context: Context, contact: String?) {
        contact?.let {
            when {
                Patterns.EMAIL_ADDRESS.matcher(contact).matches() -> {
                    // Open email app
                    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:$contact")
                    }
                    context.startActivity(Intent.createChooser(emailIntent, "Send email"))
                }
                Patterns.PHONE.matcher(contact).matches() -> {
                    // Open phone dialer
                    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$contact")
                    }
                    context.startActivity(dialIntent)
                }
                Patterns.WEB_URL.matcher(contact).matches() -> {
                    // Open web browser
                    val browserIntent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(contact)
                    }
                    context.startActivity(browserIntent)
                }
                else -> {
                  //  Toast.makeText(context, "Invalid contact information", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



}