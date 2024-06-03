package com.example.androidcleanarchitectureproject.data.domain.repositoryImpl

import com.example.androidcleanarchitectureproject.data.manager.DataManager
import com.example.androidcleanarchitectureproject.data.model.ApiError
import com.example.androidcleanarchitectureproject.data.model.DataWrapper
import com.example.androidcleanarchitectureproject.data.model.LoginUserRequest
import com.example.androidcleanarchitectureproject.data.model.ServerLoginRequest
import com.example.androidcleanarchitectureproject.data.model.TokenResponse
import com.example.androidcleanarchitectureproject.data.remote.helper.ApiHelper
import com.example.androidcleanarchitectureproject.data.domain.repository.LoginRepository
import com.example.androidcleanarchitectureproject.utils.Resource
import com.example.androidcleanarchitectureproject.utils.RetrofitInstanceObjectWithDynamicHeaders

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class DefaultAppLoginRepositoryImpl @Inject constructor(private val apiInterface: ApiHelper, val dataManager: DataManager, val retrofitInstanceObjectWithDynamicHeaders: RetrofitInstanceObjectWithDynamicHeaders) :
    LoginRepository {

    override suspend fun getAccessToken(serverLoginRequest: ServerLoginRequest): Flow<Resource<TokenResponse>> = flow {
        emit(Resource.Loading())

        try {
            val response=retrofitInstanceObjectWithDynamicHeaders.api.getAccessToken(serverLoginRequest)
            emit(Resource.Success(response!!))

        }
        catch (e:Exception){
//            emit(Resource.Error(e.message))

            if (e.message!=null){
                emit(Resource.Error(ApiError(message = e.message!!)))
            }
        }

    }



    override suspend fun requestOTPCode(loginRequest: LoginUserRequest): Flow<Resource<DataWrapper>> =
        flow{

            emit(Resource.Loading())

            try {

               val response=retrofitInstanceObjectWithDynamicHeaders.api.getOTP(loginRequest)
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