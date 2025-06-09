package com.example.testproject.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("primeapi/admin_api/get_adminHome.php")
    suspend fun getAdminHome(): Response<AdminHomeResponse>
}