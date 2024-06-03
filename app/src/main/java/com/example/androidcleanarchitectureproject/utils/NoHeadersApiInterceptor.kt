package com.example.androidcleanarchitectureproject.utils

import okhttp3.Interceptor
import okhttp3.Response

class NoHeadersApiInterceptor : Interceptor {
    /** A class with no headers in its requests at all requests which are to be appended to each and every api request **/
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .build()

        return chain.proceed(request)

    }
}