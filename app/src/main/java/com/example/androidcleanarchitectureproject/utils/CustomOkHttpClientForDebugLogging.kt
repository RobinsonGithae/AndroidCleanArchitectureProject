package com.example.androidcleanarchitectureproject.utils


import com.example.androidcleanarchitectureproject.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object CustomOkHttpClientForDebugLogging {

     val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().apply {
        /** Define OkHttpClient such that if BuildConfig is Debug enable logging else show do not enable loggng achieved with Level.None */
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY // Set the desired logging level for debug mode
                }
                addInterceptor(loggingInterceptor)


            } else {
                val noLoggingInterceptor=HttpLoggingInterceptor().apply {
                    level=HttpLoggingInterceptor.Level.NONE
                }
                addInterceptor(noLoggingInterceptor)
            }




        }.build()
    }

}