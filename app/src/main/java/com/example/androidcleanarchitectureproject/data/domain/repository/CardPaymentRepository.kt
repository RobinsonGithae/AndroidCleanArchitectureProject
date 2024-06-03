package com.example.androidcleanarchitectureproject.data.domain.repository

import com.example.androidcleanarchitectureproject.data.model.CardDetailsRequest
import com.example.myapplication.data.model.api.CardDetailsResponse
import com.example.myapplication.data.model.api.PolicyConvertionResponse
import com.example.myapplication.data.model.api.QuoteToPolWrapper
import com.example.androidcleanarchitectureproject.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CardPaymentRepository {
    /** This domain interface is intended to have no annotations */



    suspend fun processCardPayment(authorization:String, cardDetailsRequest: CardDetailsRequest):Flow<Resource<CardDetailsResponse>>


    suspend fun convertToPolicy(authorization:String, user:String,  uuid:String, toPolWrapper: QuoteToPolWrapper):Flow<Resource<PolicyConvertionResponse>>
















}