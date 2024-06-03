package com.example.androidcleanarchitectureproject.utils



import com.example.androidcleanarchitectureproject.data.remote.helper.ApiHelper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstanceObjectWithNoHeaders {

    /** Define a client with both api requests and logging interceptors here by chaining the interceptors. This retrofit object uses NoHeadersApiInterceptor which implements noHeaders at all **/
    val client= OkHttpClient.Builder().apply {
        addInterceptor(NoHeadersApiInterceptor()) /** first interceptor to add app api request headers **/
        addInterceptor(CustomOkHttpClientForDebugLogging.okHttpClient.interceptors.get(0)) //second interceptor to enable loggig if BuildConfig of app is Debug
    }.build()



    /** initialize by lazy to avoid recreating if it already exists. **/

    /** a singleton retrofit instance object **/
    val api: ApiHelper by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiUrl.BASE_URL)
            .client(client)
            .build()
            .create()
    }

}