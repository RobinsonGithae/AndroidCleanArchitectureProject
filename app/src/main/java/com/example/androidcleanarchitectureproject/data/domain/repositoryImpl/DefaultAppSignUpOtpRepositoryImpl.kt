package com.example.androidcleanarchitectureproject.data.domain.repositoryImpl

import com.example.androidcleanarchitectureproject.data.manager.DataManager
import com.example.androidcleanarchitectureproject.data.model.ApiError
import com.example.androidcleanarchitectureproject.data.model.DataWrapper
import com.example.androidcleanarchitectureproject.data.model.SimpleOtpRequest
import com.example.androidcleanarchitectureproject.data.remote.helper.ApiHelper
import com.example.androidcleanarchitectureproject.data.domain.repository.SignUpOtpRepository
import com.example.androidcleanarchitectureproject.utils.Resource
import com.example.androidcleanarchitectureproject.utils.RetrofitInstanceObjectWithDynamicHeaders
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class DefaultAppSignUpOtpRepositoryImpl @Inject constructor(private val apiInterface: ApiHelper, val dataManager: DataManager, val retrofitInstanceObjectWithDynamicHeaders: RetrofitInstanceObjectWithDynamicHeaders) :
    SignUpOtpRepository {

    override suspend fun validateSignUpOtp(otpRequest: SimpleOtpRequest): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())

        try {
            val response=retrofitInstanceObjectWithDynamicHeaders.api.verifySimpleOTP(otpRequest)
            emit(Resource.Success(response))

        }
        catch (e:Exception){
//            emit(Resource.Error(e.message))

            if (e.message!=null){
                emit(Resource.Error(ApiError(message = e.message!!)))
            }
        }

    }




    override suspend fun resendSignUpOtp(dataWrapper: DataWrapper, operationTypeHeader:String, emailHeader:String): Flow<Resource<Boolean>> =
        flow{

            emit(Resource.Loading())

            try {
                val response=retrofitInstanceObjectWithDynamicHeaders.api.requestSimpleOTP(dataWrapper,operationTypeHeader,emailHeader)
                emit(Resource.Success(response))

            }
            catch (e:Exception){
//                emit(Resource.Error(e.message))

                if (e.message!=null){
                    emit(Resource.Error(ApiError(message = e.message!!)))
                }

            }




        }






}