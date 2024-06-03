package com.example.androidcleanarchitectureproject.data.domain.repositoryImpl

import com.example.androidcleanarchitectureproject.data.manager.DataManager
import com.example.androidcleanarchitectureproject.data.model.ApiError
import com.example.androidcleanarchitectureproject.data.model.CardDetailsRequest
import com.example.myapplication.data.model.api.CardDetailsResponse
import com.example.myapplication.data.model.api.PolicyConvertionResponse
import com.example.myapplication.data.model.api.QuoteToPolWrapper
import com.example.androidcleanarchitectureproject.data.remote.helper.ApiHelper
import com.example.androidcleanarchitectureproject.data.domain.repository.CardPaymentRepository
import com.example.androidcleanarchitectureproject.utils.Resource
import com.example.androidcleanarchitectureproject.utils.RetrofitInstanceObjectWithDynamicHeaders
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject


class DefaultAppCardPaymentRepositoryImpl @Inject constructor(private val apiInterface: ApiHelper, val dataManager: DataManager, val retrofitInstanceObjectWithDynamicHeaders: RetrofitInstanceObjectWithDynamicHeaders) :
    CardPaymentRepository {

    override suspend fun processCardPayment(authorization:String, cardDetailsRequest: CardDetailsRequest): Flow<Resource<CardDetailsResponse>> = flow {
        emit(Resource.Loading())

        try {
            val response= RetrofitInstanceObjectWithNoHeadersForPaymentWithExtendedTimeout.api.paymentCard(authorization, cardDetailsRequest)
            emit(Resource.Success(response))
        }
        catch (e: HttpException){
            /** first catch block **/
            //ensure you use retrofit exception and catch an http exception

            //convert error to string
            val errorBody = e.response()?.errorBody()?.string()
            //convert to errorApiErrorType using GsonFrom String above
            val apiError = if (errorBody != null) {
                try {
                    Gson().fromJson(errorBody, ApiError::class.java)
                } catch (jsonException: JsonSyntaxException) {
                    ApiError(message = "Error parsing error response")
                }
            } else {
                ApiError(message = "Unknown error")
            }
            //finally emit the error
            emit(Resource.Error(apiError))
        }

        catch (e:Exception){
            /** second catch block **/
            //IF other exception is caught
            val apiError = ApiError(message = e.message ?: "Unknown error")
            emit(Resource.Error(apiError))

        }

    }












    override suspend fun convertToPolicy(authorization:String, user:String,uuid:String,  toPolWrapper: QuoteToPolWrapper): Flow<Resource<PolicyConvertionResponse>> = flow {
        emit(Resource.Loading())

        try {
            val response=RetrofitInstanceObjectWithNoHeadersForPaymentWithExtendedTimeout.api.convertToPolicy(authorization, user , uuid,toPolWrapper )
            emit(Resource.Success(response))


        }
        catch (e:Exception){
//            emit(Resource.Error(e.message))

            if (e.message!=null){
                emit(Resource.Error(ApiError(message = e.message!!)))
            }
        }

    }
















}