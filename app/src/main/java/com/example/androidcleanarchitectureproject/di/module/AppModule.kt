package com.example.androidcleanarchitectureproject.di.module

import android.app.Application
import android.content.Context
import com.example.androidcleanarchitectureproject.data.domain.repository.CardPaymentRepository
import com.example.androidcleanarchitectureproject.data.domain.repositoryImpl.DefaultAppCardPaymentRepositoryImpl
import com.example.androidcleanarchitectureproject.data.manager.AppDataManager
import com.example.androidcleanarchitectureproject.data.manager.DataManager
import com.example.androidcleanarchitectureproject.data.prefs.AppPreferencesHelper
import com.example.androidcleanarchitectureproject.data.prefs.PreferencesHelper
import com.example.androidcleanarchitectureproject.data.remote.helper.ApiHelper
import com.example.androidcleanarchitectureproject.utils.ApiInterceptorWithDynamicHeaders
import com.example.androidcleanarchitectureproject.utils.ApiUrl
import com.example.androidcleanarchitectureproject.utils.CustomOkHttpClientForDebugLogging
import com.example.androidcleanarchitectureproject.utils.RetrofitInstanceObjectWithDynamicHeaders


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    //new provisions
    @Provides
    @Singleton

    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton

    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL)
            .client(CustomOkHttpClientForDebugLogging.okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiHelper {
        return retrofit.create(ApiHelper::class.java)
    }




    @Provides
    @Singleton
    fun providesCardPaymentRepository(apiInterface: ApiHelper, dataManager: DataManager, retrofitInstanceObjectWithDynamicHeaders: RetrofitInstanceObjectWithDynamicHeaders): CardPaymentRepository = DefaultAppCardPaymentRepositoryImpl(apiInterface, dataManager,retrofitInstanceObjectWithDynamicHeaders)






@Provides
@Singleton
fun provideRetrofitInstanceObject3(dataManager: DataManager): RetrofitInstanceObjectWithDynamicHeaders {
    return RetrofitInstanceObjectWithDynamicHeaders(dataManager)
}


@Provides
@Singleton
fun providesApiInterceptor3(dataManager: DataManager): ApiInterceptorWithDynamicHeaders {
    return ApiInterceptorWithDynamicHeaders(dataManager)
}










    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

//    @Provides
//    @Singleton
//    fun provideAppDataManager():AppDataManager
//    {
//        return
//    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

//    @Provides
//    @PreferenceInfo
//    fun providePreferenceName(): String {
//        return AppConstants.PREF_NAME
//    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }





}

