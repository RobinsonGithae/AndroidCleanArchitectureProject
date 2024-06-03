package com.example.androidcleanarchitectureproject.data.domain.repository

import com.example.androidcleanarchitectureproject.data.model.DataWrapper
import com.example.androidcleanarchitectureproject.data.model.SimpleOtpRequest
import com.example.androidcleanarchitectureproject.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SignUpOtpRepository {
    /** This domain interface is intended to have no annotations */
    suspend fun validateSignUpOtp(otpRequest: SimpleOtpRequest):Flow<Resource<Boolean>>

    suspend fun resendSignUpOtp(dataWrapper: DataWrapper, operationTypeHeader:String, emailHeader:String):Flow<Resource<Boolean>>




}