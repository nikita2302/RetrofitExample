package com.org.retrofitexample.APIs

import com.org.retrofitexample.Models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("placeholder/user/{userID}")
    suspend fun getUser(
        @Path("userID") userID: String
    ): User
}