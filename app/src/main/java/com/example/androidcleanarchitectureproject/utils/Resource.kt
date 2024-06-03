package com.example.androidcleanarchitectureproject.utils

import com.example.androidcleanarchitectureproject.data.model.ApiError

//sealed class Resource<T>(val data: T? = null, val message: String? = null)

//sealed class Resource<T>(val data: T? = null, val error: ApiError? = null)
sealed class Resource< out T>(val data: T? = null, var error: ApiError? = null)

{

    class Success<T>(data: T) : Resource<T>(data)
//    class Error<T>(message: String?) : Resource<T>(message = message)

//    class Error<T>(error: ApiError?) : Resource<T>(error=error)
     class Error<T>(error: ApiError) : Resource<T>(error=error)
    class Loading<T>() : Resource<T>()
}