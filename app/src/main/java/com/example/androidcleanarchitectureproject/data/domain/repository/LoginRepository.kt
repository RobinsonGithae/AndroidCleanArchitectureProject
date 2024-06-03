package com.example.androidcleanarchitectureproject.data.domain.repository

import com.example.androidcleanarchitectureproject.data.model.DataWrapper
import com.example.androidcleanarchitectureproject.data.model.LoginUserRequest
import com.example.androidcleanarchitectureproject.data.model.ServerLoginRequest
import com.example.androidcleanarchitectureproject.data.model.TokenResponse
import com.example.androidcleanarchitectureproject.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    /** This domain interface is intended to have no annotations */
    suspend fun getAccessToken(serverLoginRequest: ServerLoginRequest):Flow<Resource<TokenResponse>>

    suspend fun requestOTPCode(loginRequest: LoginUserRequest):Flow<Resource<DataWrapper>>

}