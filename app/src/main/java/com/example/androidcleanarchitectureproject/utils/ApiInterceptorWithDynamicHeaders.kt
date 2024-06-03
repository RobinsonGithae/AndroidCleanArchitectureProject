package com.example.androidcleanarchitectureproject.utils

import android.os.Build
import com.example.androidcleanarchitectureproject.data.manager.DataManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ApiInterceptorWithDynamicHeaders @Inject constructor(val dataManager: DataManager)  : Interceptor {
    /** A class to Add headers common to all requests which are to be appended to each and every api request. The headers data is dynamic and is based on values of the dataManager which is Injected **/
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

            .addHeader("uuid", dataManager.getUUID() ?: "" )

            .addHeader("deviceModel", Build.MODEL)



            .build()

        return chain.proceed(request)

    }
}