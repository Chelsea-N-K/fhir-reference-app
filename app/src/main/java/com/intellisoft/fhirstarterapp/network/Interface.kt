package com.intellisoft.fhirstarterapp.network

import com.intellisoft.fhirstarterapp.model.CountyResponse
import com.intellisoft.fhirstarterapp.model.DesignationResponse
import com.intellisoft.fhirstarterapp.model.LoginResponse
import com.intellisoft.fhirstarterapp.model.RegistrationResponse
import com.intellisoft.fhirstarterapp.model.User
import com.intellisoft.fhirstarterapp.model.UserInformation
import com.intellisoft.fhirstarterapp.model.UserProfileInformationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface Interface {

    @POST("users/login")
    @Headers("Accept: application/json")

    suspend fun signInUser(
        @Body data: User
    ): Response<LoginResponse>

   @POST("users/register")
   @Headers("Accept: application/json")
    suspend fun registerUser(
        @Body dbSignIn: User
    ): Response<RegistrationResponse>



//    @GET("users/counties")
//    @Headers("Accept: application/json")
//    suspend fun searchCounties(
//        @Body query: SearchCountyQuery
//    ): Call<SearchCountyQuery.Data>

    @GET("counties")
    @Headers("Accept: application/json")
    suspend fun loadCounties():
        Response<CountyResponse>

    @GET("designations")
    @Headers("Accept: application/json")
    suspend fun loadDesignations():
            Response<DesignationResponse>

    @GET("users/profile/{id}")
    @Headers("Accept: application/json")
    suspend fun loadUserInformation(
        @Path("id") user_id: String):
            Response<UserProfileInformationResponse>


//    @GET("users/profile/")
//    suspend fun getUserInfo(
//        @Header("Authorization") token: String, // Add this line to pass the Bearer Token
//    ): Response<DbUserInfoResponse>




}

