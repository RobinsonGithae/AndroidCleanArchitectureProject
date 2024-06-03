package com.example.androidcleanarchitectureproject.utils

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptorRegisterNewProspect /*@Inject constructor(val dataManager: DataManager) */ : Interceptor {
    /** A class to Add headers specific to signup which are to be appended to each and every api request **/
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("charset","utf-8")
            .addHeader("Content-Length", "")
            .addHeader("version", "1.1.2")
            .addHeader("platform", "MOBILE")

            .addHeader("deviceType", "Android")
            .addHeader("os", "android")
            .addHeader("deviceLocation", "")
          //  .addHeader("uuid", AppUtils.generateUuid())

            .addHeader("deviceModel", Build.MODEL)




            .build()

        return chain.proceed(request)

    }
}