package com.intellisoft.fhirstarterapp.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val token: String) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var tokenRequest = request.newBuilder().header("Authorization", "Bearer $token").build()
            return chain.proceed(tokenRequest)

    }

}